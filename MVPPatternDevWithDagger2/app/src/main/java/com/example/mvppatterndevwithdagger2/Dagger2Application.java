package com.example.mvppatterndevwithdagger2;

import android.app.Application;

import com.example.mvppatterndevwithdagger2.injector.AppComponent;
import com.example.mvppatterndevwithdagger2.injector.AppModule;
import com.example.mvppatterndevwithdagger2.injector.DaggerAppComponent;


public class Dagger2Application extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeInjector();

    }

    public void initializeInjector(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
