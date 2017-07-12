package com.threeti.application;

import android.app.Application;

import com.threeti.log.LoggerService;

/**
 * Created by Administrator on 2017/7/12.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化日志
        LoggerService.init();
    }
}
