package tr.org.tobb.cartezienlistview;

/**
 * Created by fatihkocak on 10.05.2018.
 */


import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;

        import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by fkocak on 23.02.2018.
 */

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    List<ModelOfCars> modelOfCarsList = new ArrayList<>();
    LayoutInflater inflater;

    //ListviewAdapter constructor
    //Gelen değerleri set ediyor
    public ListViewAdapter(Context context, List<ModelOfCars> modelOfCarsList) {
        this.context = context;
        this.modelOfCarsList = modelOfCarsList;
    }

    @Override
    public int getCount() {
        return modelOfCarsList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelOfCarsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView model;
        TextView plaka;
        TextView renk;
        TextView koltukSayisi;
        TextView hat;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.item_list_model_cars, parent, false);//list_item_row dan yeni bir view oluşturuyoruz

        model = (TextView) itemView.findViewById(R.id.model);
        plaka = (TextView) itemView.findViewById(R.id.plaka);
        renk = (TextView) itemView.findViewById(R.id.renk);
        koltukSayisi = (TextView) itemView.findViewById(R.id.koltukSayisi);
        hat = (TextView) itemView.findViewById(R.id.hat);

        model.setText("Araç Modeli" + modelOfCarsList.get(position).getModel());
        plaka.setText("Araç Plakası:" + modelOfCarsList.get(position).getPlaka());
        renk.setText("Renk: " + modelOfCarsList.get(position).getRenk());
        koltukSayisi.setText("Koltuk Sayısı: " + String.valueOf(modelOfCarsList.get(position).getKoltukSayisi()));
        hat.setText("Hat: " + modelOfCarsList.get(position).getHat());
        return itemView;
    }

}

