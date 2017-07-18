package com.threeti.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.threeti.event.Event;
import com.threeti.event.EventBusUtil;

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
	public void processEvent(@NonNull Event Event) {

	}

}
 