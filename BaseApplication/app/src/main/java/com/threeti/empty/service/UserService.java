package com.threeti.empty.service;

import com.threeti.empty.application.EmptyApplication;
import com.threeti.empty.model.User;
import com.threeti.empty.repository.UserRepository;
import com.threeti.inface.IUiCallBack;
import com.threeti.log.LoggerManager;
import com.threeti.service.BaseService;
import com.threeti.utils.PreferencesUtil;

/**
 * Created by Administrator on 2017/7/3.
 */

public class UserService extends BaseService {

    //存储SharePreference的 User的健值
    public static final String CUR_USER = "CUR_USER";

    private static  User sCurUser  ;

    private UserRepository mUserRepository ;

    public UserService() {
        mUserRepository = new UserRepository() ;
    }

    /**
     * 用户登录
     * @param user
     * @param iUiCallBack
     */
    public void login(User user , IUiCallBack iUiCallBack){
        user = new User() ;
        user.setUserName("10202020202");
        user.setPassword("6030");
        mUserRepository.login(user ,iUiCallBack );
    }

    public static void save(User user){
        LoggerManager.d(user.toString());
        sCurUser = user ;
        PreferencesUtil.setPreferences(EmptyApplication.sEmptyApplication , CUR_USER  ,user );
    }

    public static User getCurUser(){
        if(sCurUser == null){
            sCurUser = PreferencesUtil.getPreferences(EmptyApplication.sEmptyApplication , CUR_USER ) ;
        }
        return sCurUser ;
    }
}
