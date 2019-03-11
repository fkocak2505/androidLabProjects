package com.example.mvppatterndevwithdagger2.login.presenter;

import com.example.mvppatterndevwithdagger2.LoginResultListener;
import com.example.mvppatterndevwithdagger2.login.model.ILoginModel;
import com.example.mvppatterndevwithdagger2.login.view.ILoginView;

import javax.inject.Inject;

public class LoginPresenterImpl implements ILoginPresenter {

    private ILoginModel iLoginModel;
    private ILoginView iLoginView;



    @Inject
    public LoginPresenterImpl(ILoginModel iLoginModel, ILoginView iLoginView) {
        this.iLoginModel = iLoginModel;
        this.iLoginView = iLoginView;
    }

    @Override
    public void login(String user, String password) {
        iLoginView.showLoading();
        iLoginModel.doLogin(user, password, new LoginResultListener() {
            @Override
            public void onSuccess() {
                iLoginView.hideLoading();
                iLoginView.navigateToHome();
            }

            @Override
            public void onFail() {
                iLoginView.showError("Login Error");
            }
        });
    }
}
