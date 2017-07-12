package com.threeti.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.threeti.event.EventBusUtil;
import com.threeti.net.APIError;
import com.threeti.net.APIFail;
import com.threeti.net.BaseModel;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 *  事件订阅的生命周期
 */
public abstract class SubcribeCreateDestroyActivity extends BaseActivity{

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EventBusUtil.register(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBusUtil.unregister(this);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void processErrorEvent(@NonNull APIError apiErrorError) {

	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void processFailEvent(@NonNull APIFail apiFail) {

	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void processSuccessEvent(@NonNull BaseModel baseModel) {

	}
}
 