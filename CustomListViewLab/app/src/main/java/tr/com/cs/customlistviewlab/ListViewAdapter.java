package tr.com.cs.customlistviewlab;

/**
 * Created by fkocak on 23.02.2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    ArrayList<String> sehir_adi;
    LayoutInflater inflater;

    //ListviewAdapter constructor
    //Gelen değerleri set ediyor
    public ListViewAdapter(Context context, ArrayList<String> sehir_adi) {
        this.context = context;
        this.sehir_adi = sehir_adi;
    }

    @Override
    public int getCount() {
        return sehir_adi.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView sehir_adi_textview;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_item_row, parent, false);//list_item_row dan yeni bir view oluşturuyoruz

        // oluşan itemviewin içindeki alanları Anasayfadan gelen değerler ile set ediyoruz
        sehir_adi_textview = (TextView) itemView.findViewById(R.id.sehir_adi);
        sehir_adi_textview.setText(sehir_adi.get(position));
        return itemView;
    }
}