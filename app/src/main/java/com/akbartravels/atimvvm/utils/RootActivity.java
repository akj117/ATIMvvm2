package com.akbartravels.atimvvm.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import java.util.Random;

public class RootActivity  extends AppCompatActivity {
    private int screenHeightInPixels = 0, screenWidhtInPixels = 0;
    ProgressDialog progressDoalog;
    private static RootActivity instance;

    public RootActivity() {

        instance = this;
        // TODO Auto-generated constructor stub
    }
    public static Context getContext() {
        return instance;
    }
    protected void onCreate(Bundle savedInstanceState, int resLayout) {
        super.onCreate(savedInstanceState);
        setContentView(resLayout);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenHeightInPixels = displaymetrics.heightPixels;
        screenWidhtInPixels = displaymetrics.widthPixels;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenHeightInPixels = displaymetrics.heightPixels;
        screenWidhtInPixels = displaymetrics.widthPixels;
    }

    public void showBusyAnimation(){

        progressDoalog = new ProgressDialog(RootActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();;


    }
    public void hideBusyAnimation() {

        runOnUiThread(new Runnable() {
            public void run() {
                try {	if (progressDoalog.isShowing())
                    progressDoalog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }


    protected void onResume() {
        super.onResume();
    }
    protected void onPause() {
        super.onPause();
    }
    protected void onDestroy() {

        //PersitentUtil.saveCommonData();
        super.onDestroy();
    }


    public static String GetUtl(Context context) {
        String device_id = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm";
        final int N = alphabet.length();
        Random rd = new Random();
        int iLength = 5;
        StringBuilder sb = new StringBuilder(iLength);
        StringBuilder sb1 = new StringBuilder(iLength);
        for (int i = 0; i < iLength; i++) {
            sb.append(alphabet.charAt(rd.nextInt(N)));
        }
        for (int i = 0; i < iLength; i++) {
            sb1.append(alphabet.charAt(rd.nextInt(N)));
        }

        String utl = sb.toString() + device_id + sb1;
        System.out.print("sb" + sb.toString());
        return utl.toString();
    }
}
