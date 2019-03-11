package tr.gov.saglik.uets.view.studentsReport.bitirmeSinavi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.studentReport.dataModel.ExamInfoDataModel;
import tr.gov.saglik.uets.view.studentsReport.bitirmeSinavi.adapter.ExamInfoListViewAdapter;

public class BitirmeSinaviActivityViewImpl extends AppCompatActivity implements IBitirmeSinaviActivityView {

    ListView bitirmeSinaviListView;
    List<ExamInfoDataModel> listOfExamInfoData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sr_bitirme_sinavi);

        initBitirmeSinaviActivityComponent();
        fillBitirmeSinaviListData();
        bindBitirmeSinaviList2ListViewAdapter();

        clickBitirmeSinaviListViewItem();

    }

    @Override
    public void initBitirmeSinaviActivityComponent() {
        getSupportActionBar().hide();

        bitirmeSinaviListView = (ListView) findViewById(R.id.bitirmeSinaviListView);
    }

    @Override
    public void fillBitirmeSinaviListData() {
        listOfExamInfoData = new ArrayList<>();
        listOfExamInfoData.add(new ExamInfoDataModel("1","Abant İzzet 5 Nolu Salon","08/03/2019","08/02/2019","40","Başarısız"));
        listOfExamInfoData.add(new ExamInfoDataModel("1","Abant İzzet 5 Nolu Salon","08/03/2019","08/02/2019","40","Başarısız"));
        listOfExamInfoData.add(new ExamInfoDataModel("1","Abant İzzet 5 Nolu Salon","08/03/2019","08/02/2019","40","Başarısız"));
        listOfExamInfoData.add(new ExamInfoDataModel("1","Abant İzzet 5 Nolu Salon","08/03/2019","08/02/2019","40","Başarısız"));
    }

    @Override
    public void bindBitirmeSinaviList2ListViewAdapter() {
        ExamInfoListViewAdapter examInfoListViewAdapter = new ExamInfoListViewAdapter(getApplicationContext(),listOfExamInfoData);
        bitirmeSinaviListView.setAdapter(examInfoListViewAdapter);
    }

    @Override
    public void clickBitirmeSinaviListViewItem() {
        bitirmeSinaviListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(), BitirmeSinaviDetailActivityViewImpl.class));
            }
        });
    }

}
