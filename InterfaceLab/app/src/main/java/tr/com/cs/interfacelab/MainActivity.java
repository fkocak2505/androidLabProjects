package tr.com.cs.interfacelab;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DenemeClass(getApplicationContext()).deneme();

       boolean a = new DenemeClass(getApplicationContext()).isNetworkEnable();

        Toast.makeText(getApplicationContext(),"" + a, Toast.LENGTH_SHORT).show();
    }
}
