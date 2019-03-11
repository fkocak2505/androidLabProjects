package tr.gov.saglik.uets.view.studentsReport.thesis;

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
import tr.gov.saglik.uets.model.studentReport.dataModel.ThesisInfoDataModel;
import tr.gov.saglik.uets.view.studentsReport.thesis.adapter.ThesisInfoListViewAdapter;

public class ThesisActivityViewImpl extends AppCompatActivity implements IThesisActivityView {

    ListView thesisListView;
    List<ThesisInfoDataModel> listOfThesisInfoData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thesis);

        initThesisActivityComponent();
        fillThesisListData();
        bindThesisList2ListViewAdapter();

        clickThesisListViewItem();
    }

    @Override
    public void initThesisActivityComponent() {
        getSupportActionBar().hide();

        thesisListView = (ListView) findViewById(R.id.thesisListView);
    }

    @Override
    public void fillThesisListData() {
        listOfThesisInfoData = new ArrayList<>();
        listOfThesisInfoData.add(new ThesisInfoDataModel("Umut Özgüven","08/03/2019","Beyin ve Sinir Cerrahisi","Beyindeki Kıvrımların Önemi","08/03/2019","08/10/2019","Kayıt Bulunmuyor","Kayıt Bulunmuyor"));
        listOfThesisInfoData.add(new ThesisInfoDataModel("Umut Özgüven","08/03/2019","Beyin ve Sinir Cerrahisi","Beyindeki Kıvrımların Önemi","08/03/2019","08/10/2019","Kayıt Bulunmuyor","Kayıt Bulunmuyor"));
        listOfThesisInfoData.add(new ThesisInfoDataModel("Umut Özgüven","08/03/2019","Beyin ve Sinir Cerrahisi","Beyindeki Kıvrımların Önemi","08/03/2019","08/10/2019","Kayıt Bulunmuyor","Kayıt Bulunmuyor"));
        listOfThesisInfoData.add(new ThesisInfoDataModel("Umut Özgüven","08/03/2019","Beyin ve Sinir Cerrahisi","Beyindeki Kıvrımların Önemi","08/03/2019","08/10/2019","Kayıt Bulunmuyor","Kayıt Bulunmuyor"));
    }

    @Override
    public void bindThesisList2ListViewAdapter() {
        ThesisInfoListViewAdapter thesisInfoListViewAdapter = new ThesisInfoListViewAdapter(getApplicationContext(),listOfThesisInfoData);
        thesisListView.setAdapter(thesisInfoListViewAdapter);
    }

    @Override
    public void clickThesisListViewItem() {
        thesisListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(), ThesisJuryActivityViewImpl.class));
            }
        });
    }
}
