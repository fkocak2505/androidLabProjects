package com.example.dagger2dev.model.engine;

import android.util.Log;

import com.example.dagger2dev.model.Engine;

public class LPGEngine implements Engine {
    @Override
    public void turnOn() {
        Log.v("DaggerExample", "LPG Çalıştı");
    }

    @Override
    public void turnOff() {
        Log.v("DaggerExample", "LPG durdu");
    }
}
