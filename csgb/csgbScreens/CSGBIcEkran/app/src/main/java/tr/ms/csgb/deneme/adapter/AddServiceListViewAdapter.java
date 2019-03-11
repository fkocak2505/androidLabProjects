package tr.ms.csgb.deneme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import tr.ms.csgb.deneme.GenericClass;
import tr.ms.csgb.deneme.R;
import tr.ms.csgb.deneme.activity.AddServiceActivity;
import tr.ms.csgb.deneme.data_model.AddServiceListDataModel;

public class AddServiceListViewAdapter extends BaseAdapter {

    Context mContext;
    List<AddServiceListDataModel> addServiceListDataModelList;
    LayoutInflater inflater;

    public AddServiceListViewAdapter(Context mContext, List<AddServiceListDataModel> addServiceListDataModelList) {
        this.mContext = mContext;
        this.addServiceListDataModelList = addServiceListDataModelList;
    }

    @Override
    public int getCount() {
        return addServiceListDataModelList.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.add_service_list_view_row, parent, false);

        ImageView serviceItemIcon = (ImageView) itemView.findViewById(R.id.serviceItemIcon);
        TextView serviceItemTitle = (TextView) itemView.findViewById(R.id.serviceItemTitle);
        Switch serviceIsOpen = (Switch) itemView.findViewById(R.id.serviceIsOpen);

        serviceItemIcon.setImageResource(addServiceListDataModelList.get(position).getServiceItemIcon());
        serviceItemTitle.setText(addServiceListDataModelList.get(position).getServiceItemTitle());
        serviceIsOpen.setChecked(addServiceListDataModelList.get(position).isServiceIsOpen());

        serviceIsOpen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newServiceListData(buttonView,position);
            }
        });

        return itemView;
    }

    public void newServiceListData(CompoundButton switchButton, int position) {
        boolean isOpen = switchButton.isChecked();
        switchButton.setChecked(isOpen);
        addServiceListDataModelList.get(position).setServiceIsOpen(isOpen);
        GenericClass<AddServiceListDataModel> genericClass = new GenericClass<>(mContext,addServiceListDataModelList);
        genericClass.saveList(mContext.getResources().getString(R.string.keyOfServiceListData));
    }

}
