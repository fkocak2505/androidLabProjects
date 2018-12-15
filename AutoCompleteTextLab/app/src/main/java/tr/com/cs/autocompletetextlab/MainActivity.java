package tr.com.cs.autocompletetextlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] iller = {"İSTANBUL", "ANKARA", "Ankkkaa"};
    private AutoCompleteTextView spinnerIller;
    private ArrayAdapter<String> dataAdapterForIller;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerIller = (AutoCompleteTextView) findViewById(R.id.txt);
        button = (Button) findViewById(R.id.button);

        dataAdapterForIller = new ArrayAdapter<String>(this, R.layout.row, iller);
        dataAdapterForIller.setDropDownViewResource(R.layout.row);
        spinnerIller.setAdapter(dataAdapterForIller);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, spinnerIller.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
