package com.example.fkocak.animatedtextview;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hanks.htextview.rainbow.RainbowTextView;


public class MainActivity extends AppCompatActivity {

    RainbowTextView rainbowTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] rainbow = getApplicationContext().getResources().getIntArray(R.array.rainbow);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/dancing.otf");

        rainbowTextView = (RainbowTextView)findViewById(R.id.rainbowTextView);
        rainbowTextView.setColors(rainbow);
        rainbowTextView.setTypeface(typeface);
        rainbowTextView.setText("ByTranslator");

    }

}
