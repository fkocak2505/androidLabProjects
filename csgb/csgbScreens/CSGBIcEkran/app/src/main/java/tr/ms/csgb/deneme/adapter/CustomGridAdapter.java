package tr.ms.csgb.deneme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tr.ms.csgb.deneme.R;
import tr.ms.csgb.deneme.data_model.GridViewItemModel;

public class CustomGridAdapter extends BaseAdapter {

    private Context mContext;

    private List<GridViewItemModel> gridViewItemModelList;

    public CustomGridAdapter(Context c, List<GridViewItemModel> gridViewItemModelList) {
        mContext = c;
        this.gridViewItemModelList = gridViewItemModelList;
    }

    @Override
    public int getCount() {
        return gridViewItemModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View grid = inflater.inflate(R.layout.grid_row, parent, false);
        TextView textView = (TextView) grid.findViewById(R.id.itemText);
        ImageView imageView = (ImageView) grid.findViewById(R.id.itemImage);

        if (position == gridViewItemModelList.size() - 1)
            textView.setTextColor(mContext.getResources().getColor(R.color.loginBtnUp));

        textView.setText(gridViewItemModelList.get(position).getGridItemTitle());
        imageView.setImageResource(gridViewItemModelList.get(position).getGridItemIcon());


        return grid;
    }
}