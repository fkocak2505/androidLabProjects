package tr.gov.saglik.spinnerdev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private String[] iller={"İSTANBUL","ANKARA","fatih","koçak","medyasoft","medyasoft","medyasoft","medyasoft"};
    private Spinner spinnerIller;
    private ArrayAdapter<String> dataAdapterForIller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerIller = (Spinner) findViewById(R.id.spinner1);
        dataAdapterForIller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, iller);
        dataAdapterForIller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIller.setAdapter(dataAdapterForIller);

    }
}
