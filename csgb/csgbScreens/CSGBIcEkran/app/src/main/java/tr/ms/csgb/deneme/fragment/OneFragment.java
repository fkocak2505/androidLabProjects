package tr.ms.csgb.deneme.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tr.ms.csgb.deneme.GenericClass;
import tr.ms.csgb.deneme.R;
import tr.ms.csgb.deneme.activity.AddServiceActivity;
import tr.ms.csgb.deneme.adapter.CustomGridAdapter;
import tr.ms.csgb.deneme.data_model.AddServiceListDataModel;
import tr.ms.csgb.deneme.data_model.GridViewItemModel;
import tr.ms.csgb.deneme.preferences.CustomSharedPreferences;
import tr.ms.csgb.deneme.singleton.RootSingleton;


public class OneFragment extends Fragment {

    RadioGroup homeFragmentRadioGroup;
    RadioButton radioButton;

    GridView grid;
    GridView grid1;
    List<GridViewItemModel> gridViewItemModelList;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.deneme, container, false);

        radioButtonChangeListener(view);

        CustomGridAdapter adapter = new CustomGridAdapter(getActivity().getApplicationContext(), setGridData());
        grid = (GridView) view.findViewById(R.id.grid);
        grid.setAdapter(adapter);

        CustomGridAdapter adapter1 = new CustomGridAdapter(getActivity().getApplicationContext(), setGridData());
        grid1 = (GridView) view.findViewById(R.id.grid1);
        grid1.setAdapter(adapter1);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goMenuItemActivity(position);
            }
        });

        return view;
    }

    public void goMenuItemActivity(int position) {
        String title = gridViewItemModelList.get(position).getGridItemTitle();
        switch (title) {
            case "EKLE":
                startActivity(new Intent(getActivity().getApplicationContext(), AddServiceActivity.class));
                break;
             default:
                 Toast.makeText(getActivity().getApplicationContext(), "Click", Toast.LENGTH_SHORT).show();
        }
    }

    public List<GridViewItemModel> setGridData() {
        gridViewItemModelList = new ArrayList<>();

        GenericClass<AddServiceListDataModel> genericClass = new GenericClass<>(getActivity().getApplicationContext());
        List<AddServiceListDataModel> serviceListDataModelList = genericClass.returnList(getActivity().getApplicationContext().getResources().getString(R.string.keyOfServiceListData), AddServiceListDataModel[].class);

        if (serviceListDataModelList.size() == 0) {
            gridViewItemModelList.add(new GridViewItemModel(R.drawable.home_tab_appeals, "Başvurular"));
            gridViewItemModelList.add(new GridViewItemModel(R.drawable.home_tab_contract, "Sözleşmeler"));
            gridViewItemModelList.add(new GridViewItemModel(R.drawable.home_tab_approvel_process, "Onay Süreci"));
            gridViewItemModelList.add(new GridViewItemModel(R.drawable.home_tab_isg_service, "ISG Hizmetleri"));
            gridViewItemModelList.add(new GridViewItemModel(R.drawable.home_tab_education, "Eğitim"));
        } else {
            for (AddServiceListDataModel serviceListDataItem : serviceListDataModelList) {
                if (serviceListDataItem.isServiceIsOpen())
                    gridViewItemModelList.add(new GridViewItemModel(serviceListDataItem.getServiceItemIcon(),
                            serviceListDataItem.getServiceItemTitle()));
            }
        }

        gridViewItemModelList.add(new GridViewItemModel(R.drawable.home_tab_plus, "EKLE"));

        return gridViewItemModelList;
    }

    public void radioButtonChangeListener(final View view) {
        homeFragmentRadioGroup = (RadioGroup) view.findViewById(R.id.homeRadioGrup);
        homeFragmentRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = (RadioButton) view.findViewById(checkedId);
                Toast.makeText(getActivity().getApplicationContext(), radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}