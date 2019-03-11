package com.example.dagger2dev;

import android.app.Application;

import com.example.dagger2dev.injector.AppComponent;
import com.example.dagger2dev.injector.AppModule;
import com.example.dagger2dev.injector.DaggerAppComponent;

public class Dagger2Application extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeInjector();

    }

    private void initializeInjector(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
