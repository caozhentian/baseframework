package com.threeti.empty.net;

import com.threeti.empty.model.User;
import com.threeti.net.BaseModel;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/7/3.
 */

public interface UserApi {

    @POST("login")
    // "login?" + "phoneNumber=" + username + "&accessToken=" + password
    Call<BaseModel<User>> login(@Query("phoneNumber") String username  , @Query("accessToken") String password) ;

}
