package com.akbartravels.atimvvm.Views.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.akbartravels.atimvvm.HomePageViewModel;
import com.akbartravels.atimvvm.R;
import com.akbartravels.atimvvm.databinding.ActivityHomeBinding;
import com.akbartravels.atimvvm.utils.RootActivity;
import com.akbartravels.atimvvm.utils.SharedPreferencesManager;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;



public class HomePageActivity extends RootActivity {
    private TextView txt_create,txt_retrieve;
    private LinearLayout btn_ll_retrieve_Dno,btn_ll_create_Dno;
    private Context mContext;
    private  String AUI,UTL,SID,UserName,AdminCustType,AdminCustIdentifier,RequestedFrom,RegionId,
            FYearID,WCCustRefNo,WCTitle,WCName,WCAddress,WCDOB,WCPhone,WCMobile,WCEmail,WCCountryId,
            WCPassportNo,WCPlaceOfIssue,WCDateOfIssue,WCFileTypeId,WCFileIdNumber,WCPANFileName,WCPassportFileName,
            WCRefEmployeeId,GSTStateCode,IsfrmApp,DC_FileRefNo,WCFileRefNo;
    ProgressDialog progressDoalog;
    private static final int  FROM_FORM_UPDATE_ACTIVITY=300;
    private static final int FROM_FORM_UPDATE_ACTIVITY_SUBMIT = 301;
    private static final int FROM_FORM_ACTIVITY = 200;
    private static final int FROM_FORM_ACTIVITY_SUBMIT = 201;
    private static final int FROM_FORM_RETRIEVE_ACTIVITY = 100;
    private static final int FROM_FORM_RETRIEVE_ACTIVITY_SUBMIT = 101;
    private ImageView img_sign_out;
    boolean doubleBackToExitPressedOnce;
    private SharedPreferences sharedPreferences;
    private Activity activity;
    private ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        activity = this;

        HomePageViewModel homeViewModel = new HomePageViewModel(activity);
        binding.setHomePageData(homeViewModel);

    }





    @Override
    public void onBackPressed()
    {


        if (doubleBackToExitPressedOnce) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//***Change Here***
            startActivity(intent);
            ActivityCompat.finishAffinity(this);
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getResources().getString(R.string.exit), Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }




}
