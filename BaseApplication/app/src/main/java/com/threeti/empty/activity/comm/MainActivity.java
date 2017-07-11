package com.threeti.empty.activity.comm;

import android.content.Context;
import android.content.Intent;
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


/**
 * APP的主界面  TODO 实现定制APP的UI
 */
public class MainActivity extends SubcribeCreateDestroyActivity {

    public static final Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, MainActivity.class) ;
        return intent ;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
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
