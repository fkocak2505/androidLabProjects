package com.example.mvppatterndevwithdagger2.login.model;

import android.os.Handler;

import com.example.mvppatterndevwithdagger2.LoginResultListener;

public class LoginModelImpl implements ILoginModel {

    String trialUser = "fatih";
    String trialPassword = "123";

    @Override
    public void doLogin(final String user, final String password, final LoginResultListener loginResultListener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(trialUser.equals(user) && trialPassword.equals(password))
                    loginResultListener.onSuccess();
                else
                    loginResultListener.onFail();
            }
        },3000);

    }
}
