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
import tr.ms.csgb.deneme.data_model.ListViewItemModel;

public class NavMenuListViewAdapter extends BaseAdapter {

    Context context;
    private List<ListViewItemModel> navMenuItemsData;
    LayoutInflater inflater;

    public NavMenuListViewAdapter(Context context, List<ListViewItemModel> navMenuItemsData) {
        this.context = context;
        this.navMenuItemsData = navMenuItemsData;
    }

    @Override
    public int getCount() {
        return navMenuItemsData.size();
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

        ImageView itemIcon;
        TextView itemTitle;
        TextView itemBadge;
        ImageView itemDetail;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.nav_item_list_view_row, parent, false);//list_item_row dan yeni bir view oluşturuyoruz

        itemIcon = (ImageView) itemView.findViewById(R.id.itemIcon);
        itemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
        itemBadge = (TextView) itemView.findViewById(R.id.itemBadge);
        itemDetail = (ImageView) itemView.findViewById(R.id.itemDetail);

        itemIcon.setImageResource(navMenuItemsData.get(position).getItemIcon());
        itemTitle.setText(navMenuItemsData.get(position).getItemName());

        if(navMenuItemsData.get(position).isShowBadge()){
            itemBadge.setVisibility(View.VISIBLE);
            itemBadge.setText(navMenuItemsData.get(position).getItemBadge() + " yeni");
        }

        if(navMenuItemsData.get(position).isShowDetailIcon()){
            itemDetail.setVisibility(View.VISIBLE);
            itemDetail.setImageResource(navMenuItemsData.get(position).getItemDetailIcon());
        }

        return itemView;
    }
}
