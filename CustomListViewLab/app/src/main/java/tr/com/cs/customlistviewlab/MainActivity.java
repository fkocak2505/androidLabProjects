package tr.com.cs.customlistviewlab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list; //ListView referansı
    ListViewAdapter adapter; // adapter referansı
    private ArrayList<String> sehir_adi = new ArrayList<>();// şehir adlarını tutacak array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sehir_adi.add("Ankara");
        sehir_adi.add("İstanbul");
        sehir_adi.add("Antalya");
        sehir_adi.add("İzmir");
        sehir_adi.add("Kırşehir");
        sehir_adi.add("123");
        sehir_adi.add("333");
        sehir_adi.add("22");
        sehir_adi.add("555");
        sehir_adi.add("44");
        sehir_adi.add("66");
        sehir_adi.add("888");
        sehir_adi.add("77");

        list = (ListView) findViewById(R.id.sehirList);//list objesini oluşturuyorz

        //ListViewAdapter'e değerlerimizi gönderiyoruz
        adapter = new ListViewAdapter(this, sehir_adi);

        list.setAdapter(adapter);//adı üstünde set ediyoruz


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, sehir_adi.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, sehir_adi.get(position) + "' a uzun tıkladın", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}

