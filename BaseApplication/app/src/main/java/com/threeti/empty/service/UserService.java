package com.threeti.empty.service;

import com.threeti.empty.model.User;
import com.threeti.empty.repository.UserRepository;
import com.threeti.inface.IUiCallBack;
import com.threeti.service.BaseService;

/**
 * Created by Administrator on 2017/7/3.
 */

public class UserService extends BaseService {

    private UserRepository mUserRepository ;

    public UserService(IUiCallBack iUiCallBack) {
        mUserRepository = new UserRepository(iUiCallBack) ;
    }

    public void login(User user){
        user = new User() ;
        user.setUserName("10202020202");
        user.setPassword("5187");
        mUserRepository.login(user);
    }
}
