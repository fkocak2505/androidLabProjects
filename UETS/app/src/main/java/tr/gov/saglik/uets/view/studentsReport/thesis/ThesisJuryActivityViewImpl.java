package tr.gov.saglik.uets.view.studentsReport.thesis;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.studentReport.dataModel.ThesisJuryDataModel;
import tr.gov.saglik.uets.view.studentsReport.thesis.adapter.ThesisJuryListViewAdapter;

public class ThesisJuryActivityViewImpl extends AppCompatActivity implements IThesisJuryActivityView {

    ListView thesisJuryListView;
    List<ThesisJuryDataModel> listOfThesisJuryData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thesis_detail);

        initThesisJuryActivityComponent();
        fillThesisJuryListData();
        bindThesisJuryList2ListViewAdapter();
    }


    @Override
    public void initThesisJuryActivityComponent() {
        getSupportActionBar().hide();

        thesisJuryListView = (ListView) findViewById(R.id.thesisJuryListView);
    }

    @Override
    public void fillThesisJuryListData() {
        listOfThesisJuryData = new ArrayList<>();
        listOfThesisJuryData.add(new ThesisJuryDataModel("Fatih Koçak","Dicle Tıp Fakültesi","Jüri Başkanı","Beyin ve Sinir Cerrahisi","Bulunmuyor","08/03/2019"));
        listOfThesisJuryData.add(new ThesisJuryDataModel("Fatih Koçak","Dicle Tıp Fakültesi","Jüri Başkanı","Beyin ve Sinir Cerrahisi","Bulunmuyor","08/03/2019"));
        listOfThesisJuryData.add(new ThesisJuryDataModel("Fatih Koçak","Dicle Tıp Fakültesi","Jüri Başkanı","Beyin ve Sinir Cerrahisi","Bulunmuyor","08/03/2019"));
        listOfThesisJuryData.add(new ThesisJuryDataModel("Fatih Koçak","Dicle Tıp Fakültesi","Jüri Başkanı","Beyin ve Sinir Cerrahisi","Bulunmuyor","08/03/2019"));

    }

    @Override
    public void bindThesisJuryList2ListViewAdapter() {
        ThesisJuryListViewAdapter thesisJuryListViewAdapter = new ThesisJuryListViewAdapter(getApplicationContext(),listOfThesisJuryData);
        thesisJuryListView.setAdapter(thesisJuryListViewAdapter);
    }
}
