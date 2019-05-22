package com.akbartravels.atimvvm.Controller;

import android.app.Application;
import android.content.Context;

import com.akbartravels.atimvvm.WebServices.NetworkClient;
import com.akbartravels.atimvvm.WebServices.UploadAPIs;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class AppController extends Application {

    public static final String TAG = AppController.class
            .getSimpleName();


    private static AppController mInstance;
    public static volatile Context applicationContext;
    private Scheduler scheduler;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
        mInstance = this;


    }


    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }



    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
