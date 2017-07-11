package com.threeti.empty.activity.comm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.threeti.activity.SubcribeCreateDestroyActivity;
import com.threeti.empty.R;
import com.threeti.empty.service.UserService;


/**
 * APP的登录界面  TODO 实现定制APP的UI
 */
public class LoginActivity extends SubcribeCreateDestroyActivity {

    public static final Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, LoginActivity.class) ;
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

}
