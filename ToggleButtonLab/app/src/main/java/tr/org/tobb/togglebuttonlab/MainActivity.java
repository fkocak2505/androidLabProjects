package tr.org.tobb.togglebuttonlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton,toggleButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);

        toggleButton.setTextOff("Açık");
        toggleButton.setTextOn("Açık");

        toggleButton2.setTextOff("Kapalı");
        toggleButton2.setTextOn("Kapalı");

        toggleButton.setChecked(true);
        toggleButton2.setChecked(false);


        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButton2.setChecked(false);
                toggleButton.setChecked(true);
            }
        });


        toggleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButton.setChecked(false);
                toggleButton2.setChecked(true);
            }
        });

    }
}
