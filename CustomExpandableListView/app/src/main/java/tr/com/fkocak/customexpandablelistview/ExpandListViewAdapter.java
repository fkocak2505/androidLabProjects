package tr.com.fkocak.customexpandablelistview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandListViewAdapter extends BaseExpandableListAdapter {

    public List<String> list_parent;
    public HashMap<String, List<String>> list_child;
    public Context context;
    public TextView txt;
    public TextView txt_child;
    public LayoutInflater inflater;

    public ExpandListViewAdapter(List<String> list_parent, HashMap<String, List<String>> list_child, Context context) {
        this.list_parent = list_parent;
        this.list_child = list_child;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return list_parent.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list_child.get(list_parent.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list_parent.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list_child.get(list_parent.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String title_name = (String) getGroup(groupPosition);

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.listview_header, null);


        txt = (TextView) convertView.findViewById(R.id.txt_parent);
        txt.setText(title_name);

        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String txt_child_name = (String) getChild(groupPosition, childPosition);


        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.listview_child, null);
        // fonksiyon adından da anlaşılacağı gibi parent a bağlı elemanlarının layoutunu inflate ediyoruz böylece o görüntüye ulaşmış oluyoruz

        if (getGroup(groupPosition).toString().equals("GALATASARAY")) {
            // Eğer başlığımızın ismi GALATASARAY ise elemanlarının yer aldığı arka plan rengini kırmızı yapıyoruz
            convertView.setBackgroundColor(Color.RED);
        }
        // listview_child ulaştığımıza göre içindeki bileşeni de kullanabiliyoruz daha sonradan view olarak return ediyoruz
        txt_child = (TextView) convertView.findViewById(R.id.txt_items);
        txt_child.setText(txt_child_name);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
