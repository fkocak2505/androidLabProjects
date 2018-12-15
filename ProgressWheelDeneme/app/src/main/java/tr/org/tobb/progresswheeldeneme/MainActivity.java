package tr.org.tobb.progresswheeldeneme;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.pnikosis.materialishprogress.ProgressWheel;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    TextView dneme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     final ProgressWheel progressWheel = (ProgressWheel) findViewById(R.id.progress_wheel);
        dneme = (TextView) findViewById(R.id.denmee);
        progressWheel.setVisibility(View.VISIBLE);

        dneme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressWheel.setVisibility(View.INVISIBLE);
            }
        });
    }
}
