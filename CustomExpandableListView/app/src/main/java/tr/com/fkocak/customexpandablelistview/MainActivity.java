package tr.com.fkocak.customexpandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<String> list_parent;
    public ExpandListViewAdapter expand_adapter;
    public HashMap<String, List<String>> list_child;
    public ExpandableListView expandlist_view;
    public List<String> gs_list;
    public List<String> fb_list;
    public int last_position = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandlist_view = (ExpandableListView) findViewById(R.id.expand_listview);

        Hazırla(); // expandablelistview içeriğini hazırlamak için

        // Adapter sınıfımızı oluşturmak için başlıklardan oluşan listimizi ve onlara bağlı olan elemanlarımızı oluşturmak için HaspMap türünü yolluyoruz
        expand_adapter = new ExpandListViewAdapter(list_parent, list_child, getApplicationContext());
        expandlist_view.setAdapter(expand_adapter);  // oluşturduğumuz adapter sınıfını set ediyoruz
        expandlist_view.setClickable(true);

    }

    public void Hazırla() {
        list_parent = new ArrayList<String>();  // başlıklarımızı listemelek için oluşturduk
        list_child = new HashMap<String, List<String>>(); // başlıklara bağlı elemenları tutmak için oluşturduk

        list_parent.add("Poliçe İşlemlerim");   // ikinci başlığı giriyoruz


        fb_list = new ArrayList<String>(); // ikinci başlık için alt elemanları tanımlıyoruz
        fb_list.add("Poliçelerim");

        list_child.put(list_parent.get(0), fb_list); // ikinci başlığımızı ve onların elemanlarını HashMap sınıfında tutuyoruz


    }
}
