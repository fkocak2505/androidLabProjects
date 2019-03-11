package tr.gov.saglik.uets.view.studentsReport.bitirmeSinavi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.studentReport.dataModel.ExamJuryDataModel;
import tr.gov.saglik.uets.view.studentsReport.bitirmeSinavi.adapter.ExamJuryListViewAdapter;

public class BitirmeSinaviDetailActivityViewImpl extends AppCompatActivity implements IBitirmeSinaviDetailActivityView {

    ListView bitirmeSinaviJuryListView;
    List<ExamJuryDataModel> listOfExamJuryData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sr_bitirme_sinavi_detail);

        initBitirmeSinaviJuryActivityComponent();
        fillBitirmeSinaviJuryListData();
        bindBitirmeSinaviJuryList2ListViewAdapter();
    }

    @Override
    public void initBitirmeSinaviJuryActivityComponent() {
        getSupportActionBar().hide();

        bitirmeSinaviJuryListView = (ListView) findViewById(R.id.bitirmeSinaviJuryListView);
    }

    @Override
    public void fillBitirmeSinaviJuryListData() {
        listOfExamJuryData = new ArrayList<>();
        listOfExamJuryData.add(new ExamJuryDataModel("1","Fatih Koçak","Dicle Tıp Fakültesi","Jüri Başkanı","Beyin ve Sinir Cerrahisi","Bulunmuyor","08/03/2019"));
        listOfExamJuryData.add(new ExamJuryDataModel("1","Fatih Koçak","Dicle Tıp Fakültesi","Jüri Başkanı","Beyin ve Sinir Cerrahisi","Bulunmuyor","08/03/2019"));
        listOfExamJuryData.add(new ExamJuryDataModel("1","Fatih Koçak","Dicle Tıp Fakültesi","Jüri Başkanı","Beyin ve Sinir Cerrahisi","Bulunmuyor","08/03/2019"));
        listOfExamJuryData.add(new ExamJuryDataModel("1","Fatih Koçak","Dicle Tıp Fakültesi","Jüri Başkanı","Beyin ve Sinir Cerrahisi","Bulunmuyor","08/03/2019"));
        listOfExamJuryData.add(new ExamJuryDataModel("1","Fatih Koçak","Dicle Tıp Fakültesi","Jüri Başkanı","Beyin ve Sinir Cerrahisi","Bulunmuyor","08/03/2019"));
        listOfExamJuryData.add(new ExamJuryDataModel("1","Fatih Koçak","Dicle Tıp Fakültesi","Jüri Başkanı","Beyin ve Sinir Cerrahisi","Bulunmuyor","08/03/2019"));
    }

    @Override
    public void bindBitirmeSinaviJuryList2ListViewAdapter() {
        ExamJuryListViewAdapter examInfoListViewAdapter = new ExamJuryListViewAdapter(getApplicationContext(),listOfExamJuryData);
        bitirmeSinaviJuryListView.setAdapter(examInfoListViewAdapter);
    }
}
