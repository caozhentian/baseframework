package com.threeti.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.threeti.event.EventBusUtil;


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

}
 