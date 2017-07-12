package com.threeti.empty.repository;

import com.threeti.empty.config.IpConfig;
import com.threeti.inface.IUiCallBack;
import com.threeti.repository.BaseRepository;

/**
 * Created by Administrator on 2017/7/3.
 */

public class BaseSubRepository extends BaseRepository {

    public BaseSubRepository(IUiCallBack  iUiCallBack ) {
        super(IpConfig.BASE_URL , iUiCallBack);
    }

    public BaseSubRepository( String url , IUiCallBack  iUiCallBack ) {
        super( url , iUiCallBack );
    }
}
