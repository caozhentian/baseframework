package com.threeti.repository;

import com.threeti.inface.IUiCallBack;
import com.threeti.net.RetrofitFactory;

import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/7/3.
 */

public class BaseRepository {
    protected Retrofit mRetrofit ;

    protected IUiCallBack mIUiCallBack ;

    public BaseRepository(String url , IUiCallBack iUiCallBack) {
        mRetrofit      =  RetrofitFactory.getBaseRetrofit(url);
        mIUiCallBack   =  iUiCallBack ;
    }
}
