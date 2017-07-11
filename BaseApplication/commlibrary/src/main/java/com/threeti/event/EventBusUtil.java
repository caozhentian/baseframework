package com.threeti.event;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/6/23.
 */

public class EventBusUtil {

    private static  final EventBus getEventBusIns(){
        return EventBus.getDefault() ;
    }

    public static void register(Object subscriber) {
        getEventBusIns().register(subscriber);
    }

    public  static void unregister(Object subscriber) {
        getEventBusIns().unregister(subscriber);
    }

    public static void post(Object event) {
        getEventBusIns().post(event);
    }

    public static void postSticky(Object event) {
        getEventBusIns().postSticky(event);
    }

    public boolean removeStickyEvent(Object event){
        return getEventBusIns().removeStickyEvent(event) ;
    }

}
