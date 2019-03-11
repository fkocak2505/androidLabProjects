package com.example.dagger2dev.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.dagger2dev.Dagger2Application;
import com.example.dagger2dev.R;
import com.example.dagger2dev.model.Car;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inject();

        boolean isOk = car == null ? false : true;

        if (isOk) {
            car.start();
            car.stop();
        } else
            Toast.makeText(this, "Error Inject Class. See Dagger2 Framework Coding", Toast.LENGTH_SHORT).show();
    }

    public void inject() {
        Dagger2Application app = (Dagger2Application) getApplication();
        app.getAppComponent().inject(this);
    }
}
