package com.threeti.utils;

import android.content.Context;

import com.squareup.picasso.Picasso;
import com.threeti.commlibrary.BuildConfig;

/**获取Picasso实例
 * Created by ztcao on 2017/7/19.
 */

public class PicassoUtil {

    public static final Picasso  getInstance(Context context){
        Picasso.Builder builder = new Picasso.Builder(context) ;
        if(BuildConfig.DEBUG){//Debug 模式 开启 Picasso 的日志功能
            builder.indicatorsEnabled(true) ;
            builder.loggingEnabled(true)    ;
        }
        return builder.build() ;
    }

}
