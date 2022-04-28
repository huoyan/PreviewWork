package com.zxp.myapplication;

import android.app.Application;

import com.growingio.android.sdk.collection.Configuration;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.status.BuildConfig;


public class AppApplication extends Application {

    protected static AppApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        GrowingIO.startWithConfiguration(this, new Configuration()
                .trackAllFragments()
                .setTestMode(BuildConfig.DEBUG)
                .setDebugMode(BuildConfig.DEBUG)
                .setChannel("XXX 应用商店")
        );


    }

    public static Application getInstance(){

        return application;
    }
}
