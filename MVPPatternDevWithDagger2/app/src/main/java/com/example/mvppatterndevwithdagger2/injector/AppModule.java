package com.example.mvppatterndevwithdagger2.injector;

import com.example.mvppatterndevwithdagger2.Dagger2Application;
import com.example.mvppatterndevwithdagger2.login.model.ILoginModel;
import com.example.mvppatterndevwithdagger2.login.model.LoginModelImpl;
import com.example.mvppatterndevwithdagger2.login.presenter.ILoginPresenter;
import com.example.mvppatterndevwithdagger2.login.presenter.LoginPresenterImpl;
import com.example.mvppatterndevwithdagger2.login.view.ILoginView;
import com.example.mvppatterndevwithdagger2.login.view.LoginViewImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Dagger2Application dagger2Application;

    public AppModule(Dagger2Application dagger2Application){
        this.dagger2Application = dagger2Application;
    }

    @Provides @Singleton
    ILoginView provideLoginView(){
        return new LoginViewImpl();
    }

    @Provides @Singleton
    ILoginModel provideLoginModel(){
        return new LoginModelImpl();
    }

    @Provides @Singleton
    ILoginPresenter provideLoginPresenter(ILoginModel iLoginModel, ILoginView iLoginView){
        return new LoginPresenterImpl(iLoginModel, iLoginView);
    }

}
