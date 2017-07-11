package com.threeti.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.threeti.net.APIError;
import com.threeti.net.APIFail;
import com.threeti.net.BaseModel;

import java.net.SocketTimeoutException;


/**
 * Created by ztcao on 2016/12/20. Activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity {

	public abstract void initData();
	public abstract void initView();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		ActivityManager.addActivity(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityManager.removeActivity(this);
	}

	public void showToast(String text){
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
	public void showToast(int res){
		Toast.makeText(this, getResources().getText(res), Toast.LENGTH_SHORT).show();
	}


	public void processSuccessEvent(@NonNull BaseModel baseModel) {
		if(baseModel.isSuccess()){
			dealSuccess(baseModel) ;
		}
		else{
			showToast(baseModel.getMessage());
		}
	}

	public void processErrorEvent(@NonNull APIError apiErrorError) {
		if(apiErrorError.getThrowable() instanceof SocketTimeoutException){
			showToast("网络连接超时。请检查网络");
		}
		else{
			showToast("未知错误");
		}
	}

	public void processFailEvent(@NonNull APIFail apiFail) {
		if(apiFail.getCode() == BaseModel.SUB_FAIL_STATUS_TOKEN_EXPIRE){
			showTokenExpireDialog() ;
		}
		else {
			showToast(apiFail.getMessage());
		}
	}

	/**
	 *
	 * @param baseModel
	 */
	protected<T> void dealSuccess(BaseModel baseModel){

	}

	public void showTokenExpireDialog(){
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
 