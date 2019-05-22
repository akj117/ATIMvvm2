package com.akbartravels.atimvvm.Views.Activities;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.akbartravels.atimvvm.LoginViewModel;
import com.akbartravels.atimvvm.R;

import com.akbartravels.atimvvm.databinding.ActivityLoginBinding;


public class LoginActivity extends Activity {
    private Activity activity;
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        activity = this;

        LoginViewModel loginViewModel = new LoginViewModel(activity);
        binding.setLoginData(loginViewModel);

    }
}
