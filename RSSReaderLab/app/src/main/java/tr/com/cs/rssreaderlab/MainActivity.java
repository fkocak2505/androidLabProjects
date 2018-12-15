package tr.com.cs.rssreaderlab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    TextView title,link,description;
    Button b1,b2;
    private String finalUrl="https://www.tobb.org.tr/Sayfalar/RssFeeder.php?List=MansetListesi";
    private HandleXML obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.textView);
        link = (TextView) findViewById(R.id.textView2);
        description = (TextView) findViewById(R.id.textView3);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj = new HandleXML(finalUrl);
                obj.fetchXML();

                while(obj.parsingComplete);
                title.setText(obj.getTitle());
                link.setText(obj.getLink());
                description.setText(obj.getDescription());
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,ShowingRSS.class);
                startActivity(in);
            }
        });
    }

}