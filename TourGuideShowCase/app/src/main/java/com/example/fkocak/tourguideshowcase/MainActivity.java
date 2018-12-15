package com.example.fkocak.tourguideshowcase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.view.View;

import smartdevelop.ir.eram.showcaseviewlib.GuideView;
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType;
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity;
import smartdevelop.ir.eram.showcaseviewlib.listener.GuideListener;


public class MainActivity extends AppCompatActivity {

    //private GuideView mGuideView;
    private GuideViewCustom mGuideView;
    private GuideViewCustom.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        builder = new GuideViewCustom.Builder(this)
                .setTitle("Deneme ToureGuide")
                .setContentSpan((Spannable) Html.fromHtml("<font color='red'>testing spannable</p>"))
                .setGravity(Gravity.auto) //optional
                .setDismissType(DismissType.anywhere) //optional - default DismissType.targetView
                .setTargetView(findViewById(R.id.deneme))
                .setContentTextSize(13)//optional
                .setTitleTextSize(15)//optional
                .setGuideListener(new GuideListener() {
                    @Override
                    public void onDismiss(View view) {
                        switch (view.getId()) {
                            case R.id.deneme:
                                builder.setTitle("Melis Taçer");
                                builder.setContentSpan((Spannable) Html.fromHtml("<font color='red'>melistacer</p>"));
                                builder.setTargetView(findViewById(R.id.button));
                                break;
                            case R.id.button:
                                builder.setTitle("Mobile Application");
                                builder.setContentSpan((Spannable) Html.fromHtml("<font color='red'>mobileApplication \n for translate for translate for translate for translate for translate</p>"));
                                builder.setTargetView(findViewById(R.id.textView));
                                break;
                            case R.id.textView:
                                return;
                        }

                        mGuideView = builder.build();
                        mGuideView.show();
                    }
                });

        mGuideView = builder.build();
        mGuideView.show();

        updatingForDynamicLocationViews();
    }

    private void updatingForDynamicLocationViews() {
        findViewById(R.id.button).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                mGuideView.updateGuideViewLocation();
            }
        });
    }

}
