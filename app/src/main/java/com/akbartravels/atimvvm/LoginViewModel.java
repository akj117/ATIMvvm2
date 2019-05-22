package com.akbartravels.atimvvm;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.akbartravels.atimvvm.Controller.AppController;
import com.akbartravels.atimvvm.Models.ApiResponses;
import com.akbartravels.atimvvm.Views.Activities.HomePageActivity;
import com.akbartravels.atimvvm.WebServices.NetworkClient;
import com.akbartravels.atimvvm.WebServices.UploadAPIs;
import com.akbartravels.atimvvm.utils.AesBase64Wrapper;
import com.akbartravels.atimvvm.utils.ConnectionDetector;
import com.akbartravels.atimvvm.utils.SharedPreferencesManager;
import com.android.databinding.library.baseAdapters.BR;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;

import static com.akbartravels.atimvvm.WebServices.Constants.S_AdminCustIdentifier;
import static com.akbartravels.atimvvm.WebServices.Constants.S_AdminCustType;
import static com.akbartravels.atimvvm.WebServices.Constants.S_IsfrmApp;
import static com.akbartravels.atimvvm.WebServices.Constants.S_RequestedFrom;
import static com.akbartravels.atimvvm.WebServices.Constants.S_Sid_login;
import static com.akbartravels.atimvvm.WebServices.Constants.S_auiVal;
import static com.akbartravels.atimvvm.utils.RootActivity.GetUtl;
import static com.akbartravels.atimvvm.utils.SharedPreferencesManager.UTL;


public class LoginViewModel extends BaseObservable {
    private static final String TAG = LoginViewModel.class.getSimpleName();
    private ApiResponses loginModel;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    UploadAPIs usersService;
    AppController appController;
    public ObservableInt progressBar;
    private String encryptedString;
    private ConnectionDetector objDetector;
    public LoginViewModel(Context context) {
        this.loginModel = new ApiResponses();
        this.context = context;
        progressBar = new ObservableInt(View.GONE);
        objDetector = new ConnectionDetector(context);
    }


    @Bindable
    public String getDataEmail() {
        return loginModel.getUTL();
    }

    @Bindable
    public String getDataPassword() {
        return loginModel.getAUI();
    }

    public void setDataEmail(String email) {
        loginModel.setUTL(email);
        notifyPropertyChanged(BR.dataEmail);   // This is used to have instant change in the text view with respect to edittext value

    }
    public void setDataPassword(String ps) {
        loginModel.setAUI(ps);
        notifyPropertyChanged(BR.dataPassword);   // This is used to have instant change in the text view with respect to edittext value

    }


    public View.OnClickListener onLoginButtonClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Login ", getDataEmail() + getDataPassword());
                /*AppController*/ appController = AppController.getInstance();
                UTL= GetUtl(context);
                if(UnameIsValid(getDataEmail())&&PasswordIsValid(getDataPassword()))
                {
                    // Combine username & Password
                    String combine = getDataEmail().trim() +"+"+ getDataPassword().trim();

                    // Encrypt

                    encryptedString = AesBase64Wrapper.encryptAndEncode(combine);
                    Log.e("encrypted", "- " + encryptedString);

                    // Decrypt
                    String decrypted = null;
                    try {
                        decrypted = AesBase64Wrapper.decodeAndDecrypt(encryptedString);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Log.e("decrypted", "- " + decrypted);

                    if (objDetector.isConnectingToInternet()) {
                        SharedPreferencesManager.writeString(context, SharedPreferencesManager.Uname, getDataEmail().trim());
                        SharedPreferencesManager.writeString(context, SharedPreferencesManager.Pswd, getDataPassword().trim());
                        SharedPreferencesManager.writeString(context, SharedPreferencesManager.EncryptedUname, encryptedString);
                        progressBar.set(View.VISIBLE);
                        login();
                    }
                    else
                    {
                        Toast.makeText(context, context.getResources().getString(R.string.check_internet), Toast.LENGTH_LONG).show();

                    }

                }
                else if(!UnameIsValid(getDataEmail()))
                {
                    Toast.makeText(context, context.getResources().getString(R.string.invalid_uname), Toast.LENGTH_SHORT).show();

                }
                else if(!PasswordIsValid(getDataPassword()))
                {
                    Toast.makeText(context, context.getResources().getString(R.string.invalid_pswd), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(context, context.getResources().getString(R.string.invalid_credentials), Toast.LENGTH_SHORT).show();
                }
              /*  progressBar.set(View.VISIBLE);
                login();*/

            }
        };
    }

    private void login() {
        Retrofit retrofit = NetworkClient.getRetrofitClient(context);
        UploadAPIs uploadAPIs = retrofit.create(UploadAPIs.class);
        JSONObject paramObject = new JSONObject();

        try {
            paramObject.put("AUI", S_auiVal);
            paramObject.put("UTL", UTL);
            paramObject.put("SID",S_Sid_login);
            paramObject.put("UserName", encryptedString);
            paramObject.put("AdminCustIdentifier", S_AdminCustIdentifier);
            paramObject.put("AdminCustType", S_AdminCustType);
            paramObject.put("RequestedFrom", S_RequestedFrom);
            paramObject.put("IsfrmApp", S_IsfrmApp);

              /* AppController appController = AppController.create(context);
        UsersService usersService = appController.getUserService();*/

            Disposable disposable = uploadAPIs.loginUser(paramObject.toString())
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
                                Intent i = new Intent(context, HomePageActivity.class);
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

    private boolean PasswordIsValid(String pswd) {
        if(pswd != null &&!pswd.trim().equals(""))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean UnameIsValid(String uname) {
        if(uname!=null&&!uname.trim().equals(""))
        {
            return true;
        }
        else
        {
            return false;
        }

    }

}
