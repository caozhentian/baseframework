package com.threeti.empty.application;

import com.threeti.application.BaseApplication;

/**
 * Created by ztcao on 2017/7/12.
 */

public class EmptyApplication extends BaseApplication {

    public static  EmptyApplication sEmptyApplication ;

    @Override
    public void onCreate() {
        super.onCreate();
        sEmptyApplication = this ;
        //TODO  加入应用需要的初始化逻辑
    }

}
