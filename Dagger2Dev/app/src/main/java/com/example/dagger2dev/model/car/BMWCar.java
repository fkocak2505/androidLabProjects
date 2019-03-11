package com.example.dagger2dev.model.car;

import android.util.Log;

import com.example.dagger2dev.ResultListener;
import com.example.dagger2dev.model.Car;
import com.example.dagger2dev.model.Engine;

import android.os.Handler;

import javax.inject.Inject;

public class BMWCar implements Car {

    Engine engine;

    @Inject
    public BMWCar(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void start() {
        Log.v("DaggerExample", "BMW Car çalıştı");
        engine.turnOn();
    }

    @Override
    public void stop() {
        Log.v("DaggerExample", "BMW Car durdu");
        engine.turnOff();
    }
}
