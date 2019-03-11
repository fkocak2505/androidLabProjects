package com.example.dagger2dev.injector;

import com.example.dagger2dev.Dagger2Application;
import com.example.dagger2dev.model.Car;
import com.example.dagger2dev.model.Engine;
import com.example.dagger2dev.model.car.BMWCar;
import com.example.dagger2dev.model.engine.LPGEngine;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Dagger2Application dagger2Application;

    public AppModule(Dagger2Application dagger2Application){
        this.dagger2Application = dagger2Application;
    }

    /*@Provides @Singleton
    Dagger2Application provideApp(){
        return dagger2Application;
    }*/

    @Provides @Singleton
    Engine provideEngine(){
        return new LPGEngine();
    }

    @Provides @Singleton
    Car provideCar(Engine engine){
        return new BMWCar(engine);
    }


}
