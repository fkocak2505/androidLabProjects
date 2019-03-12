package com.example.fabcirclemenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.github.clans.fab.FloatingActionMenu;


public class MainActivity extends Activity {

    View dimmerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*FloatingActionsMenu rightLabels = (FloatingActionsMenu) findViewById(R.id.right_labels);
        FloatingActionButton addedOnce = new FloatingActionButton(this);
        addedOnce.setTitle("Added once");
        rightLabels.addButton(addedOnce);

        FloatingActionButton addedTwice = new FloatingActionButton(this);
        addedTwice.setTitle("Added twice");
        rightLabels.addButton(addedTwice);
        rightLabels.removeButton(addedTwice);
        rightLabels.addButton(addedTwice);*/

        dimmerView = (View) findViewById(R.id.dimmer_view);


        /*FloatingActionMenu floatingActionMenu = (FloatingActionMenu) findViewById(R.id.menu);
        floatingActionMenu.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                setBackgroundDimming(opened);
            }
        });*/
    }

    private void setBackgroundDimming(boolean dimmed) {
        final float targetAlpha = dimmed ? 1f : 0;
        final int endVisibility = dimmed ? View.VISIBLE : View.GONE;
        dimmerView.setVisibility(View.VISIBLE);
        dimmerView.animate()
                .alpha(targetAlpha)
                .setDuration(500)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        dimmerView.setVisibility(endVisibility);
                    }
                })
                .start();
    }

}