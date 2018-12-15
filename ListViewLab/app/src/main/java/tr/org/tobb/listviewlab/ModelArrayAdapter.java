package tr.org.tobb.listviewlab;

/**
 * Created by fatihkocak on 7.05.2018.
 */

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ModelArrayAdapter extends ArrayAdapter<Model4ShowCars>
{
    private final Context context;
    private List<Model4ShowCars> values;

    public ModelArrayAdapter(Context context, List<Model4ShowCars> tvalues) {
        super(context, R.layout.list_item_iller, tvalues);
        this.context = context;
        this.values = tvalues;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_item_iller, parent,
                false);
        TextView model = (TextView) rowView.findViewById(R.id.model);
        TextView renk = (TextView) rowView.findViewById(R.id.renk);
        TextView plaka = (TextView) rowView.findViewById(R.id.plaka);
        TextView koltuk = (TextView) rowView.findViewById(R.id.seat);

        Model4ShowCars model4ShowCars = ((Model4ShowCars) values.get(position));
            model.setText(model4ShowCars.getModel());
            renk.setText(model4ShowCars.getColor());
            plaka.setText(model4ShowCars.getPlates());
            koltuk.setText(model4ShowCars.getSeats());

        return rowView;
    }
}