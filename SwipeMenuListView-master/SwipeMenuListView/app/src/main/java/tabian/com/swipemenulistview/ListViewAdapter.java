package tabian.com.swipemenulistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    List<String> data;
    LayoutInflater inflater;

    public ListViewAdapter(Context mContext, List<String> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.deneme,viewGroup,false);

        TextView aaa = (TextView) itemView.findViewById(R.id.aaa);
        aaa.setText(data.get(i));

        return itemView;


    }
}

