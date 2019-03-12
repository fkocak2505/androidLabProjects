package com.example.fabcirclemenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import terranovaproductions.newcomicreader.FloatingActionMenu;


public class Deneme extends AppCompatActivity {

    View dimmedView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deneme);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager(),
                Deneme.this));
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        dimmedView = (View) findViewById(R.id.dimmerView);
        FloatingActionMenu floatingActionMenu = (FloatingActionMenu) findViewById(R.id.fab_menu);
        floatingActionMenu.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                setBackgroundDimming(opened);
            }
        });

        FloatingActionButton fab_random = (FloatingActionButton) findViewById(R.id.fab_random);
        fab_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
                setClickFabMain();
            }
        });
        FloatingActionButton fab_download = (FloatingActionButton) findViewById(R.id.fab_download);
        fab_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
                setClickFabMain();
            }
        });
        FloatingActionButton fab_browser = (FloatingActionButton) findViewById(R.id.fab_browser);
        fab_browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
                setClickFabMain();
            }
        });
    }

    private void setBackgroundDimming(boolean dimmed) {
        final float targetAlpha = dimmed ? 1f : 0;
        final int endVisibility = dimmed ? View.VISIBLE : View.GONE;
        dimmedView.setVisibility(View.VISIBLE);
        dimmedView.animate()
                .alpha(targetAlpha)
                .setDuration(500)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        dimmedView.setVisibility(endVisibility);
                    }
                })
                .start();
    }

    private void setClickFabMain() {
        FloatingActionButton fab_main = (FloatingActionButton) findViewById(R.id.fab_main);
        fab_main.performClick();
    }
}
