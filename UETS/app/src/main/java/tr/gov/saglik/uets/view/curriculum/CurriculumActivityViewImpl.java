package tr.gov.saglik.uets.view.curriculum;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.curriculum.dataModel.CurriculumDataModel;
import tr.gov.saglik.uets.model.programs.dataModel.FilteredSearchCriteriaDataModel;
import tr.gov.saglik.uets.view.curriculum.adapter.CurriculumListViewAdapter;
import tr.gov.saglik.uets.view.programs.adapter.FilteredSearchCriteriaListViewAdapter;

public class CurriculumActivityViewImpl extends AppCompatActivity implements ICurriculumActivityView {

    ListView curriculumListView;
    List<CurriculumDataModel> listOfCurriculumData;

    //Filter Dialog Component
    Dialog filterDialog;
    TextView closeFilterDialog;
    TextView filterTitle;
    TextView doFiltered;
    ListView filteredSearchCriteriaListView;
    List<FilteredSearchCriteriaDataModel> listOfSearchCriteriaData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum);

        initProgramsActivityComponent();
        fillProgramsListViewData();
        bindPrograms2Adapter();

        clickProgramsListView();
    }

    @Override
    public void initProgramsActivityComponent() {
        getSupportActionBar().hide();
        curriculumListView = (ListView) findViewById(R.id.curriculumListView);
    }

    @Override
    public void fillProgramsListViewData() {
        listOfCurriculumData = new ArrayList<>();
        listOfCurriculumData.add(new CurriculumDataModel("7 Mart 2019", "3 Yıl", "Anestezyoloji", "Çekirdek Müfredat", "v.1.0", R.drawable.demands_pending_approvel_status, R.drawable.download));
        listOfCurriculumData.add(new CurriculumDataModel("7 Mart 2019", "3 Yıl", "Anestezyoloji", "Çekirdek Müfredat", "v.1.0", R.drawable.demands_pending_approvel_status, R.drawable.download));
        listOfCurriculumData.add(new CurriculumDataModel("7 Mart 2019", "3 Yıl", "Anestezyoloji", "Çekirdek Müfredat", "v.1.0", R.drawable.demands_pending_approvel_status, R.drawable.download));

    }

    @Override
    public void bindPrograms2Adapter() {
        CurriculumListViewAdapter programsListViewAdapter = new CurriculumListViewAdapter(getApplicationContext(), listOfCurriculumData);
        curriculumListView.setAdapter(programsListViewAdapter);
    }

    @Override
    public void clickProgramsListView() {
        curriculumListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CurriculumActivityViewImpl.this, "Belge indiriliyor..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void clickFilter(View view) {
        openFilterDialog();
    }

    @Override
    public void openFilterDialog() {
        filterDialog = new Dialog(this, R.style.Theme_Dialog);

        filterDialogConfig(filterDialog);
        initFilterDialogComponent();
        fillSearchCriteriaListViewData();
        bindSearchCriteriaData2Adapter();


        /// Close Dialog
        closeFilterDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterDialog.dismiss();
            }
        });

        // Do Filtered
        doFiltered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*finish();
                startActivity(getIntent());*/
                Toast.makeText(CurriculumActivityViewImpl.this, "Filtreleme yapılıyor..", Toast.LENGTH_SHORT).show();
            }
        });

        /// Select ListView Item
        filteredSearchCriteriaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                filterTitle.setText(listOfSearchCriteriaData.get(position).getSearchCriteriaTitle());
            }
        });


        filterDialog.show();
    }

    @Override
    public void filterDialogConfig(Dialog dialog) {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.filter_dialog);

        ViewGroup.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        ((WindowManager.LayoutParams) layoutParams).gravity = Gravity.BOTTOM;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
    }

    @Override
    public void initFilterDialogComponent(){
        closeFilterDialog = (TextView) filterDialog.findViewById(R.id.closeFilter);
        filterTitle = (TextView) filterDialog.findViewById(R.id.filter);
        doFiltered = (TextView) filterDialog.findViewById(R.id.doFilterd);
        filteredSearchCriteriaListView = (ListView) filterDialog.findViewById(R.id.filterListView);
    }

    @Override
    public void fillSearchCriteriaListViewData(){
        listOfSearchCriteriaData = new ArrayList<>();
        listOfSearchCriteriaData.add(new FilteredSearchCriteriaDataModel("Müfredat Türü", R.drawable.nav_item_detail_icon));
        listOfSearchCriteriaData.add(new FilteredSearchCriteriaDataModel("Eğitim Süresi", R.drawable.nav_item_detail_icon));
        listOfSearchCriteriaData.add(new FilteredSearchCriteriaDataModel("Uzmanlık Dalı", R.drawable.nav_item_detail_icon));
        }

    @Override
    public void bindSearchCriteriaData2Adapter(){
        FilteredSearchCriteriaListViewAdapter filteredSearchCriteriaListViewAdapter = new FilteredSearchCriteriaListViewAdapter(getApplicationContext(),listOfSearchCriteriaData);
        filteredSearchCriteriaListView.setAdapter(filteredSearchCriteriaListViewAdapter);
    }
}
