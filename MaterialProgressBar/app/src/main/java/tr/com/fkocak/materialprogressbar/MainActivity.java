package tr.com.fkocak.materialprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wang.avi.AVLoadingIndicatorView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AVLoadingIndicatorView avLoadingIndicatorView = new AVLoadingIndicatorView(this);
        avLoadingIndicatorView.show();
    }
}
