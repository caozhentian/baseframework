package com.threeti.empty.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.threeti.activity.SubcribeCreateDestroyActivity;
import com.threeti.empty.R;
import com.threeti.empty.service.UserService;
import com.threeti.net.APIError;
import com.threeti.net.APIFail;
import com.threeti.net.BaseModel;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;



public class MainActivity extends SubcribeCreateDestroyActivity {

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserService userService = new UserService() ;
        userService.login(null);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void processErrorEvent(@NonNull APIError apiErrorError) {
        super.processErrorEvent(apiErrorError);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void processFailEvent(@NonNull APIFail apiFail) {
        super.processFailEvent(apiFail);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void processSuccessEvent(@NonNull BaseModel baseModel) {
        super.processSuccessEvent(baseModel);
    }
}
