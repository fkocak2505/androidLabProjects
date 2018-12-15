package tr.org.tobb.cardviewlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;

import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    ListView lv;
    Context context;

    Map<Integer, List<String>> mapOfList = new HashMap<>();
    List<String> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    List<String> list3 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        list.add("Fatih");
        list.add("Kocak");
        list.add("Deneme");
        mapOfList.put(0,list);

        list1.add("D1");
        list1.add("D2");
        list1.add("Deneme1");
        mapOfList.put(1,list1);

        list2.add("D3");
        list2.add("D4");
        list2.add("Deneme2");
        mapOfList.put(2,list2);

        list3.add("D5");
        list3.add("D6");
        list3.add("Deneme3");
        mapOfList.put(3,list3);

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new RecyclerAdapter(context, mapOfList,R.layout.item,3,"textView"));


    }



}