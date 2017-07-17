package com.threeti.repository;

import com.threeti.net.RetrofitFactory;

import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/7/3.
 */

public class BaseRepository {
    protected Retrofit mRetrofit ;

    public BaseRepository(String url ) {
        mRetrofit      =  RetrofitFactory.getBaseRetrofit(url);
    }
}
