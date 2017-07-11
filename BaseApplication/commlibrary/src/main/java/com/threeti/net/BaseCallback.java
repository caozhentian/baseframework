package com.threeti.net;

import android.content.Context;
import android.support.annotation.UiThread;
import android.util.Log;

import com.threeti.activity.ActivityManager;
import com.threeti.commlibrary.R;
import com.threeti.dialog.CustomProgressDialog;
import com.threeti.event.EventBusUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ztcao on 2017/2/4.
 */

public class BaseCallback<T> implements Callback<BaseModel<T>> {

    public static final String TAG = "BaseCallback" ;

    //区分是哪个网络接口的请求
    private volatile  int mApiOperationCode ;

    CustomProgressDialog mCustomProgressDialog ;
    @UiThread
    public BaseCallback(int apiOperationCode) {
        mApiOperationCode = apiOperationCode;
        //UI层收到可展现进度条
        Context context = ActivityManager.getTopActivity() ;
        mCustomProgressDialog = new CustomProgressDialog(context , R.style.dialog) ;
        mCustomProgressDialog.show() ;
    }


    @Override
    @UiThread
    public void onResponse(Call<BaseModel<T>> call, Response<BaseModel<T>> response) {
        if (response.isSuccessful() && response.errorBody() == null) {
            BaseModel<T> model = response.body();
            if (model == null) {
                Log.e(TAG, "数据解析出现异常");
                EventBusUtil.post(new APIFail(mApiOperationCode ,response.code(), response.message()));
            } else if(!model.isSuccess()){ //业务逻辑错误
                EventBusUtil.post(new APIFail(mApiOperationCode ,model.getSubFailStatus(), model.getMessage()));
            }else {
                model.setApiOperationCode(mApiOperationCode);
                EventBusUtil.post(model);
            }
        } else { //an application-level failure such as a 404 or 500
            EventBusUtil.post(new APIFail(mApiOperationCode ,response.code(), response.message()));
            Log.e(TAG, response.code() + ":" + response.message());
        }
        mCustomProgressDialog.cancel();//网络请求结束
    }

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     */
    @Override
    @UiThread
    public void onFailure(Call call, Throwable throwable) { //失败
        Log.e(TAG, "onFailure            " + throwable.getMessage());
        throwable.printStackTrace();
        EventBusUtil.post(new APIError(mApiOperationCode, throwable));
        mCustomProgressDialog.cancel(); //网络请求结束
    }

}
