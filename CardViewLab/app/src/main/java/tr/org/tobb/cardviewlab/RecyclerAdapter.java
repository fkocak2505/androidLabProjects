package tr.org.tobb.cardviewlab;

/**
 * Created by fkocak on 9.01.2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rajat on 2/8/2015.
 */
public class RecyclerAdapter extends BaseAdapter{
    Map<Integer, List<String>> result;
    Context context;
    int layoutFile;
    int textViewArrLength;
    String resourceName;
    int index = 0;

    List<String> fkocak = new ArrayList<>();

    private static LayoutInflater inflater=null;
    public RecyclerAdapter(Context context, Map<Integer, List<String>> prgmNameList, int layoutFile, int textViewArrLength, String resourceName) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        this.context=context;
        this.layoutFile = layoutFile;
        this.textViewArrLength = textViewArrLength;
        this.resourceName = resourceName;

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv[] = new TextView[textViewArrLength];

        public void a(){
            for(int i = 0; i < textViewArrLength ; i++){
                tv[i] = new TextView(context);
            }
        }

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(layoutFile, null);

        holder.a();

        for(int i = 0 ; i < result.size(); i++) {
            for(int j = 0 ; j< result.get(position).size(); j++){
//                holder.tv[i].setText(result.get(i).get(j));
                fkocak.add(result.get(i).get(j));
            }
        }

        for(int i = 1 ; i <= textViewArrLength; i++) {
            int a = backGroundToChange(resourceName, i);

            holder.tv[i-1] = (TextView) rowView.findViewById(a);
            holder.tv[i-1].setText(fkocak.get(index));
            index++;

        }
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(context, "You Clicked "+fkocak.get(position), Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }

    private int backGroundToChange(String resourceName1,int position) {
        String resourceName = resourceName1 + position;
        int resourceID = context.getResources().getIdentifier(resourceName, "id", context.getPackageName());
        return resourceID;
    }

}