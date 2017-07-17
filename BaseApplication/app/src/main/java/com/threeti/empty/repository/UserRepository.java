package com.threeti.empty.repository;

import com.threeti.empty.model.User;
import com.threeti.empty.net.UserApi;
import com.threeti.inface.IUiCallBack;
import com.threeti.net.BaseCallback;
import com.threeti.net.BaseModel;

import retrofit2.Call;

/**
 * Created by Administrator on 2017/7/3.
 */

public class UserRepository extends BaseSubRepository {
    protected UserApi mUserApi ;

    public UserRepository() {
        super()  ;
        mUserApi  = mRetrofit.create(UserApi.class);
    }

    public void login(User user, IUiCallBack<User> iUiCallBack){
        Call<BaseModel<User>> call   =  mUserApi.login(user.getUserName() , user.getPassword()) ;
        call.enqueue(new BaseCallback<User>(iUiCallBack));
    }

}
