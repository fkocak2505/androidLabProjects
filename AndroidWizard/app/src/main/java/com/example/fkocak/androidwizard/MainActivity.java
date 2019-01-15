package com.example.fkocak.androidwizard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.anton46.stepsview.StepsView;

import cn.iwgang.countdownview.CountdownView;

public class MainActivity extends AppCompatActivity {

    StepsView stepsView;
    CountdownView mCvCountdownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] labels = new String[10];

        stepsView = (StepsView) findViewById(R.id.stepsView);

        mCvCountdownView = (CountdownView)findViewById(R.id.cv_countdownViewTest1);
        mCvCountdownView.start(20000); // Millisecond



        mCvCountdownView.setOnCountdownEndListener(new CountdownView.OnCountdownEndListener() {
            @Override
            public void onEnd(CountdownView cv) {
                Toast.makeText(MainActivity.this, "Bitti", Toast.LENGTH_SHORT).show();
            }
        });



        stepsView.setLabels(labels)
                .setBarColorIndicator(getApplicationContext().getResources().getColor(R.color.primary))
                .setProgressColorIndicator(getApplicationContext().getResources().getColor(R.color.orange))
                .setLabelColorIndicator(getApplicationContext().getResources().getColor(R.color.orange))
                .setCompletedPosition(4)
                .drawView();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stepsView.setCompletedPosition(5).drawView();
                mCvCountdownView.start(10000);
            }
        });


    }
}
