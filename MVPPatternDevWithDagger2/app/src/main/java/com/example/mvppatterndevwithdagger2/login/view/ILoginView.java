package com.example.mvppatterndevwithdagger2.login.view;

public interface ILoginView {

    void showLoading();
    void hideLoading();
    void showError(String msg);
    void navigateToHome();

}
