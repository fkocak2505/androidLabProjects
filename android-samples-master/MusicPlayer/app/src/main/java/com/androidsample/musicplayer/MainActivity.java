package com.androidsample.musicplayer;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQ_CODE_PICK_FILE = 123;
    private static final int REQ_PERMISSION = 1543;

    private ImageView mPlayPauseIv;
    private TextView mTitleTv;
    private SeekBar mSeekBar;

    private Timer mTimer;
    private TimerTask mTimerTask = new TimerTask() {
        @Override
        public void run() {
            if (mSeekBar != null) mSeekBar.setProgress(MediaPlayerManager.getCurrentTime());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitleTv = (TextView) findViewById(R.id.track_name_tv);

        mSeekBar = (SeekBar) findViewById(R.id.seek_bar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                MediaPlayerManager.seekTo(seekBar.getProgress());
            }
        });

        mPlayPauseIv = (ImageView) findViewById(R.id.play_pause_iv);
        mPlayPauseIv.setOnClickListener(this);

        findViewById(R.id.btn_select_music).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play_pause_iv:
                if (!MediaPlayerManager.isInitialized()) {  //Never used media player? select file to play
                    selectMusic();
                } else if (MediaPlayerManager.isPlaying()) {    //If currently playing?? Pause.
                    MediaPlayerManager.pauseMusic();

                    //stop the seek bar
                    if (mTimer != null) mTimer.cancel();

                    setPlayPauseImage();
                } else {        //Currently in pause state. Play from where it was pause.
                    MediaPlayerManager.startPlaying();
                    setPlayPauseImage();

                    //stop the seek bar
                    mSeekBar.setMax(MediaPlayerManager.getTotalDuration());
                    mSeekBar.setProgress(MediaPlayerManager.getCurrentTime());
                    mTimer = new Timer();
                    mTimer.scheduleAtFixedRate(mTimerTask, 0, 1000);
                }
                break;
            case R.id.btn_select_music:
                //select music
                selectMusic();
                break;
        }
    }

    private void selectMusic() {
        //Check for the read permission.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQ_PERMISSION);
            return;
        }

        //Create file picker intent
        Intent intent;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            intent = new Intent(Intent.ACTION_PICK);
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        }

        intent.setType("audio/*");
        startActivityForResult(intent, REQ_CODE_PICK_FILE);
    }

    private void setPlayPauseImage() {
        mPlayPauseIv.setImageResource(MediaPlayerManager.isPlaying() ? R.drawable.ic_pause : R.drawable.ic_play);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQ_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) selectMusic();
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE_PICK_FILE && resultCode == Activity.RESULT_OK) {
            if (data != null && data.getData() != null) {
                try {
                    //stop if there are any currently playing music
                    MediaPlayerManager.stopMusic();

                    //start the new track
                    MediaPlayerManager.startNewTrack(this, data.getData());

                    //set the title
                    mTitleTv.setText(new File(data.getData().getPath()).getName());

                    //set the max value of the seek bar
                    mSeekBar.setMax(MediaPlayerManager.getTotalDuration());
                    mSeekBar.setProgress(0);
                    mTimer = new Timer();
                    mTimer.scheduleAtFixedRate(mTimerTask, 0, 1000);

                    //change the button icon
                    setPlayPauseImage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MediaPlayerManager.stopMusic();
    }
}
