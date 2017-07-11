package com.threeti.empty.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ztcao on 2017/7/3.
 */

public class User {

    @SerializedName("userName")
    private String mUserName  ;

    @SerializedName("password")
    private String mPassword  ;

    @SerializedName("telphone")
    private String mTelphone    ;

    //TODO 加入需要的用户的其他属性 和 生成 GET SET 方法

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getTelphone() {
        return mTelphone;
    }

    public void setTelphone(String telphone) {
        mTelphone = telphone;
    }
}
