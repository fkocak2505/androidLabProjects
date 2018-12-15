package tr.org.tobb.pdfwordhtmlreader;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String url = "https://s3-eu-west-1.amazonaws.com/tobbservice/Test.docx";
        String url = "https://s3-eu-west-1.amazonaws.com/tobbservice/test.pdf";

        if(url.toString().contains(".doc") || url.toString().contains(".docx")){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse( "http://docs.google.com/viewer?url=" + url), "text/html");
            startActivity(intent);
        } else if(url.toString().contains(".pdf")){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }
}
