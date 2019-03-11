package tr.ms.csgb.deneme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

import tr.ms.csgb.deneme.GenericClass;
import tr.ms.csgb.deneme.R;
import tr.ms.csgb.deneme.adapter.AddServiceListViewAdapter;
import tr.ms.csgb.deneme.data_model.AddServiceListDataModel;

public class AddServiceActivity extends AppCompatActivity {

    ListView serviceListView;
    ImageView goBack;

    AddServiceListViewAdapter serviceAdapter;
    List<AddServiceListDataModel> serviceListDataModelList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);


        serviceListView = (ListView) findViewById(R.id.serviceListView);
        goBack = (ImageView) findViewById(R.id.goBack);

        serviceAdapter = new AddServiceListViewAdapter(this, fillServiceData());
        serviceListView.setAdapter(serviceAdapter);

        serviceListViewItemClickListener();
        goBackActivity();

    }

    public void serviceListViewItemClickListener() {
        /*serviceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                newServiceListData(view, position);
            }
        });*/
    }


    public void goBackActivity() {
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    /*public void newServiceListData(View view, int position) {
        Switch switchButton = (Switch) view.findViewById(R.id.serviceIsOpen);
        boolean isOpen = switchButton.isChecked();

        switchButton.setChecked(!isOpen);
        serviceListDataModelList.get(position).setServiceIsOpen(!isOpen);

        GenericClass<AddServiceListDataModel> genericClass = new GenericClass<>(getApplicationContext(),serviceListDataModelList);
        genericClass.saveList(getResources().getString(R.string.keyOfServiceListData));

    }*/

    public List<AddServiceListDataModel> fillServiceData() {
        GenericClass<AddServiceListDataModel> genericClass = new GenericClass<>(getApplicationContext());
        serviceListDataModelList = genericClass.returnList(getApplicationContext().getResources().getString(R.string.keyOfServiceListData), AddServiceListDataModel[].class);
        if (serviceListDataModelList.size() == 0) {
            serviceListDataModelList = new ArrayList<>();
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_appeals, "Başvurular", true));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_contract, "Sözleşmeler", true));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_approvel_process, "Onay Süreci", true));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_isg_service, "ISG Hizmetleri", true));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_education, "Eğitim", true));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_plus, "Fatih", false));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_plus, "Koçak", false));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_plus, "Deneme1", false));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_plus, "Deneme2", false));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_plus, "Deneme3", false));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_plus, "Deneme4", false));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_plus, "Deneme5", false));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_plus, "Deneme6", false));
            serviceListDataModelList.add(new AddServiceListDataModel(R.drawable.home_tab_plus, "Deneme7", false));
        }
        return serviceListDataModelList;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
