package com.example.mvppatterndevwithdagger2.login.model;

import com.example.mvppatterndevwithdagger2.LoginResultListener;

public interface ILoginModel {

    void doLogin(String user, String password, LoginResultListener loginResultListener);

}
