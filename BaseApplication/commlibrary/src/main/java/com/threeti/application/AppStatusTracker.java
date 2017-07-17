/**
 * 
 */
package com.threeti.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * @author Administrator
 *
 */
public class AppStatusTracker implements Application.ActivityLifecycleCallbacks {
    /** 切换到后台的时间戳*/
    //public long screenOnTime = 0l;
    /** 当前是否有activity在运行 */
    public int count = 0;
    /** 屏幕点亮*/
    //public boolean screenOn = true;
    /** 是否是在后台*/
    public boolean isBackGround = false;
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        
    }

    @Override
    public void onActivityStarted(Activity activity) {
        count++;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        isBackGround = false;
        //screenOnTime = 0l;

    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {
        count--;
        if(count == 0){
            isBackGround = true;
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }
}
