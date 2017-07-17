package com.threeti.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.threeti.utils.ToastUtil;


/**
 * Created by ztcao on 2016/12/20. Activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity{

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
		ToastUtil.show(this, text, Toast.LENGTH_SHORT);
	}
	public void showToast(@IdRes int res){
		ToastUtil.show(this, res, Toast.LENGTH_SHORT);
	}

}
 