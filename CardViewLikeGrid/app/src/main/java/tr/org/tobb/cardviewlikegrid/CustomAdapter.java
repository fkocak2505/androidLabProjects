package tr.org.tobb.cardviewlikegrid;

/**
 * Created by fatihkocak on 13.04.2018.
 */

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{
    Context c;
    ArrayList<Spacecraft> spacecrafts;

    public CustomAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public int getCount() {
        return spacecrafts.size();
    }

    @Override
    public Object getItem(int i) {
        return spacecrafts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(c).inflate(R.layout.model,viewGroup,false);
        }

        final Spacecraft s= (Spacecraft) this.getItem(i);

        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.deneme);
        ImageView img= (ImageView) view.findViewById(R.id.spacecraftImg);
        TextView nameTxt= (TextView) view.findViewById(R.id.nameTxt);
        TextView propTxt= (TextView) view.findViewById(R.id.propellantTxt);

        //BIND
        nameTxt.setText(s.getName());
        propTxt.setText(s.getPropellant());
        img.setImageResource(s.getImage());
        constraintLayout.setBackgroundResource(s.getImage());


        return view;
    }
}