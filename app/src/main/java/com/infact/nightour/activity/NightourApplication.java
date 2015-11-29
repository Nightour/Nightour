package com.infact.nightour.activity;

import android.app.Application;
import android.util.Log;

/**
 * Created by Neto on 21/11/2015.
 */
public class NightourApplication extends Application {
    private static final String TAG = "NightourApplication";
    private static NightourApplication instance = null;
    public static final NightourApplication getInstance(){
        return instance;
    }
    @Override
    public void onCreate(){
        Log.d(TAG, "NightourApplication.onCreate()");
        instance = this;
        super.onCreate();
    }
    @Override
    public void onTerminate(){
        super.onTerminate();
        Log.d(TAG, "NightourApplication.onTerminate()");
    }
}
