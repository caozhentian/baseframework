package com.threeti.empty.activity.comm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.threeti.activity.BaseActivity;
import com.threeti.empty.R;
import com.threeti.empty.model.User;
import com.threeti.empty.service.UserService;
import com.threeti.inface.BaseUiCallBack;
import com.threeti.net.BaseModel;


/**
 * APP的启动界面  TODO 实现定制APP的UI
 */
public class SplashActivity extends BaseActivity {

    public static final Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, SplashActivity.class) ;
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
        setContentView(R.layout.act_splash);
        UserService userService = new UserService() ;
        userService.login(null , new BaseUiCallBack<User>(this){
            @Override
            public void processBusinessSuccessEvent(@NonNull BaseModel<User> baseModel) {

            }
        });
    }

}
