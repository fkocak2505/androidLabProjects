package tr.com.cs.rssreaderlab;

/**
 * Created by fkocak on 23.02.2018.
 */


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class ShowingRSS extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        WebView w1 = (WebView) findViewById(R.id.webView);
        w1.loadUrl("http://tutorialspoint.com/android/sampleXML.xml");
    }
}