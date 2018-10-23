package com.example.estelle.activitydemo;

import android.app.Application;

import com.example.estelle.activitydemo.roomtest.db.AppDatabase;
import com.example.estelle.activitydemo.roomtest.db.DataRepository;


public class MyApplication extends Application {
    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, mAppExecutors);
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase());
    }

}
