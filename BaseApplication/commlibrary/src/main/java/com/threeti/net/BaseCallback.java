package com.threeti.net;

import android.content.Context;
import android.support.annotation.UiThread;

import com.threeti.activity.ActivityManager;
import com.threeti.commlibrary.R;
import com.threeti.dialog.CustomProgressDialog;
import com.threeti.inface.IUiCallBack;
import com.threeti.log.LoggerManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**网络请求的回调处理 运行在UI线程
 * Created by ztcao on 2017/7/12
 */

public class BaseCallback<T> implements Callback<BaseModel<T>> {

    public static final String TAG = "BaseCallback" ;

    //区分是哪个网络接口的请求
    private volatile IUiCallBack mIUiCallBack  ;

    CustomProgressDialog mCustomProgressDialog ;
    @UiThread
    public BaseCallback(IUiCallBack iUiCallBack) {
        mIUiCallBack  = iUiCallBack;
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
            LoggerManager.d(model);
            if (model == null) {
                LoggerManager.e("数据解析出现异常");
                mIUiCallBack.processNetFailEvent(new APIFail(response.code(), response.message()));
            } else if(!model.isSuccess()){ //业务逻辑错误
                mIUiCallBack.processNetFailEvent(new APIFail( model.getSubFailStatus(), model.getMessage()));
            }else {
                mIUiCallBack.processNetSuccessEvent(model);
            }
        } else { //an application-level failure such as a 404 or 500
            mIUiCallBack.processNetFailEvent(new APIFail( response.code(), response.message()));
            LoggerManager.e( response.code() + ":" + response.message());
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
        LoggerManager.e("onFailure            " + throwable.getMessage());
        throwable.printStackTrace();
        mIUiCallBack.processNetErrorEvent(new APIError( throwable));
        mCustomProgressDialog.cancel(); //网络请求结束
    }

}
