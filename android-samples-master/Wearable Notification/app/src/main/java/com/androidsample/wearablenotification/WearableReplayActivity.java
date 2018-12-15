package com.androidsample.wearablenotification;

import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.androidsample.wearablenotification.myapplication.R;

/**
 * This is the activity that will open while user replies from the android wear device via remote input.
 */
public class WearableReplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wearable_replay);

        CharSequence replayString;

        //get the voice replays from the remote input.
        Bundle bundle = RemoteInput.getResultsFromIntent(getIntent());
        if (bundle != null) {
            replayString = bundle.getCharSequence(WearableNotification.REMOTE_INPUT_LABEL);
        } else {
            replayString = "No replay from the response.";
        }

        Toast.makeText(this, replayString, Toast.LENGTH_LONG).show();

        finish();
    }
}
