package com.threeti.empty.repository;

import com.threeti.empty.config.IpConfig;
import com.threeti.repository.BaseRepository;

/**
 * Created by Administrator on 2017/7/3.
 */

public class BaseSubRepository extends BaseRepository {

    public BaseSubRepository() {
        super(IpConfig.BASE_URL);
    }

    public BaseSubRepository(String url) {
        super(url);
    }
}
