package com.threeti.inface;

import android.content.Context;
import android.support.annotation.NonNull;

import com.threeti.net.APIError;
import com.threeti.net.APIFail;
import com.threeti.net.BaseModel;
import com.threeti.utils.ToastUtil;

import java.net.SocketTimeoutException;

/**
 * Created by Administrator on 2017/7/17.
 */

public   abstract class BaseUiCallBack<T> implements IUiCallBack<T> {

    private Context mContext ;

    public BaseUiCallBack(Context context) {
        mContext = context;
    }

    @Override
    public     void processNetSuccessEvent(@NonNull BaseModel<T> baseModel){
        if(baseModel.isSuccess()){
            processBusinessSuccessEvent(baseModel) ;
        }
        else{
            processBusinessFailEvent(baseModel) ;
        }
    } ;

    @Override
    public abstract  void processBusinessSuccessEvent(@NonNull BaseModel<T> baseModel)  ;

    @Override
    public void processBusinessFailEvent(@NonNull BaseModel<T> baseModel) {
        if(baseModel.getSubFailStatus() == BaseModel.SUB_FAIL_STATUS_TOKEN_EXPIRE){
            showTokenExpireDialog() ;
        }
        else{
            ToastUtil.show(mContext , baseModel.getMessage());
        }
    }


    @Override
    public void processNetErrorEvent(@NonNull APIError apiErrorError) {
        if(apiErrorError.getThrowable() instanceof SocketTimeoutException){
            ToastUtil.show(mContext , "网络连接超时。请检查网络" ) ;
        }
        else{
            ToastUtil.show(mContext , apiErrorError.getThrowable().getMessage() ) ;
        }
    }

    @Override
    public void processNetFailEvent(@NonNull APIFail apiFail) {
        if(apiFail.getCode() == BaseModel.SUB_FAIL_STATUS_TOKEN_EXPIRE){
            showTokenExpireDialog() ;
        }
        else {
            ToastUtil.show(mContext ,apiFail.getMessage());
        }
    }

    @Override
    public void showTokenExpireDialog() {
//		OKCancelDlg.createCancelOKDlg(this, "登录超时", "重新登录", "退出应用", new ICancelOK() {
//			@Override
//			public void cancel() {
//				ActivityExitManage.finishAll();
//			}
//
//			@Override
//			public void ok() {
//				ActivityExitManage.finishAll();
//                startActivity(LoginActivity.newIntent(BaseActivity.this));
//			}
//		});
    }
}
