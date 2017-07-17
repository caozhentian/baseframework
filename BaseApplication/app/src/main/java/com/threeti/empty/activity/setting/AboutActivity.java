package com.threeti.empty.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.threeti.activity.BaseActivity;
import com.threeti.empty.R;


/**
 * APP的登录界面  TODO 实现定制APP的UI
 */
public class AboutActivity extends BaseActivity {

    public static final Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, AboutActivity.class) ;
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
        setContentView(R.layout.act_login);

    }
}
