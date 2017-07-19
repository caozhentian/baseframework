package com.threeti.application;

import android.app.Application;

import com.threeti.file.FileManager;
import com.threeti.log.CrashHandler;
import com.threeti.log.LoggerManager;

/**
 * Created by ztcao on 2017/7/12.
 */

public class BaseApplication extends Application {

    private static AppStatusTracker tracker = new AppStatusTracker();

    @Override
    public void onCreate() {
        super.onCreate();
        //跟踪Activity的生命周期
        registerActivityLifecycleCallbacks(tracker)  ;
        //初始化日志
        FileManager.init()    ;
        LoggerManager.init()  ;
        CrashHandler.getInstance().init(this);
    }
}
