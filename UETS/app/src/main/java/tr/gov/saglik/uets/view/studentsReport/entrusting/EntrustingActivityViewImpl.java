package tr.gov.saglik.uets.view.studentsReport.entrusting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.studentReport.dataModel.EntrustingDataModel;
import tr.gov.saglik.uets.view.studentsReport.entrusting.adapter.EntrustingListViewAdapter;

public class EntrustingActivityViewImpl extends AppCompatActivity implements IEntrustingActivityView {

    ListView entrustingListView;
    List<EntrustingDataModel> listOfEntrustingData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrusting);

        initEntrustingActivityComponent();
        fillEntrustingListData();
        bindEntrustingList2ListViewAdapter();

    }

    @Override
    public void initEntrustingActivityComponent() {
        getSupportActionBar().hide();

        entrustingListView = (ListView) findViewById(R.id.entrustingListView);
    }

    @Override
    public void fillEntrustingListData() {
        listOfEntrustingData = new ArrayList<>();
        listOfEntrustingData.add(new EntrustingDataModel("Yurtiçi Görevlendirme","Kurum İçi Rotasyon","08/03/2019","08/05/2019","Abant İzzet Anesteiyoloji","Abant İzzet Tıp Fakültesi","Tamamlandı"));
        listOfEntrustingData.add(new EntrustingDataModel("Yurtiçi Görevlendirme","Kurum İçi Rotasyon","08/03/2019","08/05/2019","Abant İzzet Anesteiyoloji","Abant İzzet Tıp Fakültesi","Tamamlandı"));
        listOfEntrustingData.add(new EntrustingDataModel("Yurtiçi Görevlendirme","Kurum İçi Rotasyon","08/03/2019","08/05/2019","Abant İzzet Anesteiyoloji","Abant İzzet Tıp Fakültesi","Tamamlandı"));
        listOfEntrustingData.add(new EntrustingDataModel("Yurtiçi Görevlendirme","Kurum İçi Rotasyon","08/03/2019","08/05/2019","Abant İzzet Anesteiyoloji","Abant İzzet Tıp Fakültesi","Tamamlandı"));
    }

    @Override
    public void bindEntrustingList2ListViewAdapter() {
        EntrustingListViewAdapter entrustingListViewAdapter = new EntrustingListViewAdapter(getApplicationContext(),listOfEntrustingData);
        entrustingListView.setAdapter(entrustingListViewAdapter);
    }
}
