package com.threeti.inface;

import android.support.annotation.NonNull;

import com.threeti.net.APIError;
import com.threeti.net.APIFail;
import com.threeti.net.BaseModel;

/**网络调用UI层的回调，所有的UI 包括Activity 和 Fragment 如果有网络请求，都需要实现此接口
 * Created by ztcao on 2017/7/12.
 */

public interface IUiCallBack {

    public void processNetSuccessEvent(@NonNull BaseModel baseModel) ;

    public void processNetErrorEvent(@NonNull APIError apiErrorError) ;

    public void processNetFailEvent(@NonNull APIFail apiFail) ;

    public void showTokenExpireDialog() ;
}
