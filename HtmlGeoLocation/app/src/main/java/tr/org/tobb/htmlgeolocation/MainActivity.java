package tr.org.tobb.htmlgeolocation;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    public static class PlaceholderFragment extends Fragment {

        WebView myBrowser;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container,
                    false);

            myBrowser = (WebView) rootView.findViewById(R.id.webView);
            myBrowser.getSettings().setJavaScriptEnabled(true);
            myBrowser.getSettings().setGeolocationEnabled(true);

            myBrowser.setWebChromeClient(new WebChromeClient(){
                @Override
                public void onGeolocationPermissionsShowPrompt(String origin,
                                                               GeolocationPermissions.Callback callback) {

                    callback.invoke(origin, true, false);
                }
            });

            myBrowser.loadUrl("https://s3-eu-west-1.amazonaws.com/tobbservice/htmlgeolocation/location.html");


            return rootView;
        }
    }

    public boolean isNetworkEnable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
