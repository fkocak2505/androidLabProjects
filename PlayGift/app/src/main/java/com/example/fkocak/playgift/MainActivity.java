package com.example.fkocak.playgift;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                startActivity(new Intent(getApplicationContext(),Deneme.class));

            }
        }, 6000);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(getApplicationContext()).load(R.raw.setting).into(imageView);
    }
}
