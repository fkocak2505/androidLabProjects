package com.example.fkocak.customtoggleswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import co.aenterhy.toggleswitch.ToggleSwitchButton;

public class MainActivity extends AppCompatActivity {

    ToggleSwitchButton toggleSwitchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleSwitchButton = (ToggleSwitchButton) findViewById(R.id.toggle);

        toggleSwitchButton.setOnTriggerListener(new ToggleSwitchButton.OnTriggerListener() {
            @Override
            public void toggledUp() {
                Toast.makeText(MainActivity.this, "Camera", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void toggledDown() {
                Toast.makeText(MainActivity.this, "Audio", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
