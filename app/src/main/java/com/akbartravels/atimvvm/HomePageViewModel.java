package com.akbartravels.atimvvm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.akbartravels.atimvvm.Controller.AppController;
import com.akbartravels.atimvvm.Models.ApiResponses;
import com.akbartravels.atimvvm.Views.Activities.HomePageActivity;
import com.akbartravels.atimvvm.Views.Activities.LoginActivity;
import com.akbartravels.atimvvm.WebServices.NetworkClient;
import com.akbartravels.atimvvm.WebServices.UploadAPIs;
import com.akbartravels.atimvvm.utils.SharedPreferencesManager;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.akbartravels.atimvvm.WebServices.Constants.S_AdminCustIdentifier;
import static com.akbartravels.atimvvm.WebServices.Constants.S_AdminCustType;
import static com.akbartravels.atimvvm.WebServices.Constants.S_FYearID;
import static com.akbartravels.atimvvm.WebServices.Constants.S_IsfrmApp;
import static com.akbartravels.atimvvm.WebServices.Constants.S_RegionId;
import static com.akbartravels.atimvvm.WebServices.Constants.S_RequestedFrom;
import static com.akbartravels.atimvvm.WebServices.Constants.S_Sid_create;
import static com.akbartravels.atimvvm.WebServices.Constants.S_Sid_login;
import static com.akbartravels.atimvvm.WebServices.Constants.S_WCRefEmployeeId;
import static com.akbartravels.atimvvm.WebServices.Constants.S_auiVal;
import static com.akbartravels.atimvvm.utils.SharedPreferencesManager.UTL;

public class HomePageViewModel extends BaseObservable {
    private Context context;
    AppController appController;
    public ObservableInt progressBar;
    private static final String TAG = HomePageViewModel.class.getSimpleName();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private SharedPreferences sharedPreferences;
    public HomePageViewModel(Context context) {
        this.context = context;
        appController = AppController.getInstance();
        progressBar = new ObservableInt(View.GONE);
        sharedPreferences = SharedPreferencesManager.getPreferencesInstance(context);
    }

    public View.OnClickListener onLogoutButtonClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, LoginActivity.class);
                context. startActivity(i);
                ((Activity) context).overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
                Toast.makeText(context, context.getResources().getString(R.string.logout_success), Toast.LENGTH_SHORT).show();

            }
        };
    }
    public View.OnClickListener onCreateDnumber() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.set(View.VISIBLE);
                createDNO();

            }
        };
    }
    public View.OnClickListener onRetrieveDnumber() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, LoginActivity.class);
                context. startActivity(i);
                ((Activity) context).overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
                Toast.makeText(context, context.getResources().getString(R.string.logout_success), Toast.LENGTH_SHORT).show();

            }
        };
    }

    private void createDNO() {
        Retrofit retrofit = NetworkClient.getRetrofitClient(context);
        UploadAPIs uploadAPIs = retrofit.create(UploadAPIs.class);
        JSONObject paramObject = new JSONObject();
        try {
            paramObject.put("AUI", S_auiVal);
            //paramObject.put("UTL", UTL);
            paramObject.put("UTL", sharedPreferences.getString(SharedPreferencesManager.UTL, ""));
            paramObject.put("SID",S_Sid_create);
            // paramObject.put("UserName", sharedPreferences.getString(SharedPreferencesManager.EncryptedUname, ""));

            paramObject.put("UserName", sharedPreferences.getString(SharedPreferencesManager.EncryptedUname, ""));
            paramObject.put("AdminCustIdentifier", S_AdminCustIdentifier);
            paramObject.put("AdminCustType", S_AdminCustType);
            paramObject.put("RequestedFrom", S_RequestedFrom);
            paramObject.put("RegionId", S_RegionId);
            paramObject.put("FYearID", S_FYearID);
            paramObject.put("WCRefEmployeeId", S_WCRefEmployeeId);
            paramObject.put("IsfrmApp", S_IsfrmApp);

            paramObject.put("WCCustRefNo", "");
            paramObject.put("WCTitle", "Mr");
            paramObject.put("WCName","namee");
            paramObject.put("WCAddress", "Adresse");
            paramObject.put("WCDOB", "01/01/1990");
            paramObject.put("WCPhone", "123456789");
            paramObject.put("WCMobile", "123654789");
            paramObject.put("WCEmail", "ab@cd.com");

            paramObject.put("WCCountryId", "1");
            paramObject.put("WCPassportNo", "ASDFGFHGJ");
            paramObject.put("WCPlaceOfIssue", "kerale");
            paramObject.put("WCDateOfIssue", "01/01/1999");
            paramObject.put("WCFileTypeId","1");
            paramObject.put("WCFileIdNumber", "adsd");
            paramObject.put("WCPANFileName", "http:\\/\\/13.233.124.16\\/beta\\/test\\/ati_tool\\/resources\\/7jZ24bShWf.jpg");
            paramObject.put("WCPassportFileName", "http:\\/\\/13.233.124.16\\/beta\\/test\\/ati_tool\\/resources\\/7jZ24bShWf.jpg");
            paramObject.put("GSTStateCode", "MH");



              /* AppController appController = AppController.create(context);
        UsersService usersService = appController.getUserService();*/

            Disposable disposable = uploadAPIs.createDNO(paramObject.toString())
                    .subscribeOn(appController.subscribeScheduler())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<ApiResponses>() {
                        @Override public void accept(ApiResponses userResponse) throws Exception {
                            progressBar.set(View.GONE);
                            if(userResponse.getTransdetails().getResponseStatus().equalsIgnoreCase("false"))
                            {
                                Log.d("#####success",userResponse.getTransdetails().getResponseMessage().toString());
                                //  progressDoalog.dismiss();
                                SharedPreferencesManager.writeString(context, SharedPreferencesManager.AUI, userResponse.getAUI());
                                SharedPreferencesManager.writeString(context, SharedPreferencesManager.SID, userResponse.getSID());
                                SharedPreferencesManager.writeString(context, SharedPreferencesManager.UTL, userResponse.getUTL());
                                SharedPreferencesManager.writeString(context, SharedPreferencesManager.WCFileRefNo, userResponse.getWCFileRefNo());

                                SharedPreferencesManager.writeString(context, SharedPreferencesManager.ResponseCode, userResponse.getTransdetails().getResponseCode());
                                SharedPreferencesManager.writeString(context, SharedPreferencesManager.ResponseCount, userResponse.getTransdetails().getResponseCount());
                                SharedPreferencesManager.writeString(context, SharedPreferencesManager.ResponseMessage, userResponse.getTransdetails().getResponseMessage());
                                SharedPreferencesManager.writeString(context, SharedPreferencesManager.ResponseStatus, userResponse.getTransdetails().getResponseStatus());


                                Log.d(TAG,userResponse.getTransdetails().getResponseMessage()) ;
                                Intent i = new Intent(context, LoginActivity.class);
                                context. startActivity(i);
                                ((Activity) context).overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
                            }

                            else
                            {
                                Toast.makeText(context, userResponse.getTransdetails().getResponseMessage(), Toast.LENGTH_SHORT).show();

                            }

                        }
                    }, new Consumer<Throwable  > () {
                        @Override public void accept(Throwable throwable) throws Exception {
                            progressBar.set(View.GONE);
                            Toast.makeText(context, context.getResources().getString(R.string.error_msg), Toast.LENGTH_SHORT).show();
                            Log.d(TAG,throwable.toString()) ;
                        }
                    });

            compositeDisposable.add(disposable);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
