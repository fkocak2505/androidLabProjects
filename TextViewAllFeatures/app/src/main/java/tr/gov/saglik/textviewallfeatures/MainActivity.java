package tr.gov.saglik.textviewallfeatures;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);
        //textView.setText("Koçak",TextView.BufferType.EDITABLE); // Edit edilebilir text için BufferType Editable Seçilir.
        //textView.setText("Fatih Koçak Fatih Koçak Fatih Koçak",TextView.BufferType.SPANNABLE); /// Span olarak text alıp kısmi renk değiştirme işlemi
        textView.setText("Fatih Koçak");
        textView.setTextSize(18);

        /*Editable editable = textView.getEditableText();
        editable.insert(0,"Fatih ");*/

        /*Spannable span = (Spannable) textView.getText();
        span.setSpan(new ForegroundColorSpan(0xff0000ff),0,"Fatih Koçak Fatih Koçak Fatih Koçak".length(),Spannable.SPAN_INCLUSIVE_EXCLUSIVE);*/

        //Linkify.addLinks(textView, Linkify.PHONE_NUMBERS | Linkify.WEB_URLS); /// android:autoLink Özelliği

        /// Sadece (Api 26) ve Üst versiyonlarda çalışıyor. Text' i oto size yapmak için kullanılıyor.
        textView.setAutoSizeTextTypeUniformWithConfiguration(12,100,2,TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);

        // Sadece Api 23 ve üzerinde çalışıyor. Multiline textleri balanced etmeye yarıyor..
        //textView.setBreakStrategy(Layout.BREAK_STRATEGY_BALANCED);


    }
}
