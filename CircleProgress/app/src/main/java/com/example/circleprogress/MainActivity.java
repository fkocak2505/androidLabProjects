package com.example.circleprogress;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;

public class MainActivity extends AppCompatActivity {

    AnimatedCircleLoadingView animatedCircleLoadingView;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animatedCircleLoadingView = (AnimatedCircleLoadingView) findViewById(R.id.circle_loading_view);

        startLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animatedCircleLoadingView.stopOk();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(),Deneme.class));
                    }
                }, 5000);

            }
        }, 3000);

    }

    private void startLoading() {
        animatedCircleLoadingView.startIndeterminate();
    }
}
