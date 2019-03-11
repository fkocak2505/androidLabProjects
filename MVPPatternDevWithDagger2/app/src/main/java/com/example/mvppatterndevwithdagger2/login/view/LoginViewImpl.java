package com.example.mvppatterndevwithdagger2.login.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mvppatterndevwithdagger2.Dagger2Application;
import com.example.mvppatterndevwithdagger2.R;
import com.example.mvppatterndevwithdagger2.login.model.LoginModelImpl;
import com.example.mvppatterndevwithdagger2.login.presenter.ILoginPresenter;
import com.example.mvppatterndevwithdagger2.login.presenter.LoginPresenterImpl;

import javax.inject.Inject;

public class LoginViewImpl extends AppCompatActivity implements ILoginView {

    LoginPresenterImpl loginPresenter;

    /*@Inject
    ILoginPresenter iLoginPresenter;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*inject();

        iLoginPresenter.login("fatih","123");*/

        loginPresenter = new LoginPresenterImpl(new LoginModelImpl(),this);
        loginPresenter.login("fatih","123555");

    }

    public void inject(){
        Dagger2Application app = (Dagger2Application) getApplication();
        app.getAppComponent().inject(this);
    }

    @Override
    public void showLoading() {
        Log.v("Show Loading","Loading başladı");
    }

    @Override
    public void hideLoading() {
        Log.v("Hide Loading", "Loading bitti");
    }

    @Override
    public void showError(String msg) {
        Log.v("Login Error", msg);
    }

    @Override
    public void navigateToHome() {
        Log.v("Login Success", "Login Başarılı");
    }
}
