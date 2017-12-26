package com.zz.chapter02;

import android.util.Log;

/**
 Created by zz on 12/26/2017. */

public class LogUtils {
    public static final boolean DEBUG = BuildConfig.LOGGABLE;

    public static void i (String tag, String msg){
        if(DEBUG){
            Log.i(tag, msg);
        }
    }
}
