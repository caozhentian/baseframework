package com.threeti.activity;

import android.app.Activity;

import java.util.Stack;

/**
 * 退出系统处理类
 * 
 * @author hy 在 BaseActivity 的 onCreate()方法中调用了 ActivityManager 的
 *         addActivity()方法，表明 将当前正在创建的活动添加到活动管理器里。然后在 BaseActivity中重写
 *         onDestroy()方法， 并调用了 ActivityCollector 的
 *         removeActivity()方法，表明将一个马上要销毁的活动从活动管 理器里移除。
 */
public class ActivityManager {


	public static Stack<Activity> activities = new Stack<>();

	/**
	 * 添加Activity到集合
	 * 
	 * @param activity
	 */
	public static void addActivity(Activity activity) {
		//activities.add(activity);
		activities.push(activity) ;
	}

	/**
	 * 移除activity
	 * 
	 * @param activity
	 */
	public static void removeActivity(Activity activity) {
		activities.remove(activity) ;
	}

	/**
	 * 关闭所有Activity 从此以后，不管你想在什么地方退出程序，只需要调用 ActivityManager.finishAll()方法
	 * 就可以了直接退出程序。
	 */
	public static void finishAll() {
		for (Activity activity : activities) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}

	public static Activity  getTopActivity(){
		if(activities.size() == 0){
			return null ;
		}
		Activity topActivity = activities.peek() ;
		return topActivity ;
	}

}
