package com.example.fkocak.showcaseintroapptrial;

import android.content.Intent;
import android.os.Bundle;

import com.example.fkocak.showcaseintroapptrial.lib.AhoyOnboarderActivityCustom;
import com.example.fkocak.showcaseintroapptrial.lib.AhoyOnboarderCardCustom;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AhoyOnboarderActivityCustom {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AhoyOnboarderCardCustom ahoyOnboarderCard1 = new AhoyOnboarderCardCustom("Link Cards", "Sign up for free by activating your credit cards.", R.drawable.spend);
        AhoyOnboarderCardCustom ahoyOnboarderCard2 = new AhoyOnboarderCardCustom("Dine Out", "Choose from 100's of restaurants with new spots added daily.", R.drawable.food);
        AhoyOnboarderCardCustom ahoyOnboarderCard3 = new AhoyOnboarderCardCustom("Fatih Koçak", "Mobil Yazılım Mühendisi", R.drawable.reward);
        AhoyOnboarderCardCustom ahoyOnboarderCard4 = new AhoyOnboarderCardCustom("Melis Taçer", "Grafik Tasarım Uzman Yardımcısı", R.drawable.reward);
        AhoyOnboarderCardCustom ahoyOnboarderCard5 = new AhoyOnboarderCardCustom("Translator App", "Translate Uygulaması", R.drawable.reward);

        ahoyOnboarderCard1.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard2.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard3.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard4.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard5.setBackgroundColor(R.color.black_transparent);

        List<AhoyOnboarderCardCustom> pages = new ArrayList<>();

        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);
        pages.add(ahoyOnboarderCard4);
        pages.add(ahoyOnboarderCard5);

        for (AhoyOnboarderCardCustom page : pages) {
            page.setTitleColor(R.color.white);
            page.setDescriptionColor(R.color.grey_200);
        }

        setFinishButtonTitle("Get Started");
        showNavigationControls(true);
        setGradientBackground();
        //setGradientBackground(R.drawable.download);
        //setImageBackground(R.drawable.download);


        //Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        //setFont(face);

        setInactiveIndicatorColor(R.color.grey_600);
        setActiveIndicatorColor(R.color.white);

        setOnboardPages(pages);

    }

    @Override
    public void onFinishButtonPressed() {
        startActivity(new Intent(getApplicationContext(),Deneme.class));
    }


}
