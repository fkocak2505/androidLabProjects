package com.example.mvppatterndevwithdagger2.injector;


import com.example.mvppatterndevwithdagger2.login.view.LoginViewImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = AppModule.class)
public interface AppComponent {

    void inject(LoginViewImpl loginViewImpl);

}
