package com.example.designpattern;

import android.app.Application;
import android.content.Context;

/**
 * @author wb.huhuimin
 * @Description: [功能描述]
 * @Time: [序号]${date} ${time}
 */
public class MyApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
