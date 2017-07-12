package com.threeti.service;

import com.threeti.inface.IUiCallBack;

/**
 * Created by Administrator on 2017/7/3.
 */

public class BaseService {

    protected IUiCallBack mIUiCallBack ;

    public IUiCallBack getIUiCallBack() {
        return mIUiCallBack;
    }

    public void setIUiCallBack(IUiCallBack IUiCallBack) {
        mIUiCallBack = IUiCallBack;
    }
}
