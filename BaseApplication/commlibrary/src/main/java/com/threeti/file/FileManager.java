package com.threeti.file;

import com.threeti.utils.ExternalStorageUtil;

import java.io.File;

/**
 * 文件管理
 * Created by ztcao on 2017/7/12.
 */

public class FileManager {

    public  static final String CRASH_PATH = ExternalStorageUtil.getExternalStoragePath() + File.separator + "threeti" + File.separator + "crash" ;


    public final static  void init(){
        File file = new File(CRASH_PATH);
        if(!file.exists()){
            file.mkdir() ;
        }
    }
}
