package tr.gov.saglik.uets.view.decisions;

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
import tr.gov.saglik.uets.model.decisions.dataModel.DecisionsDataModel;
import tr.gov.saglik.uets.view.decisions.adapter.DecisionsListViewAdapter;
import tr.gov.saglik.uets.view.decisions.decisionDetail.DecisionDetailActivityImpl;

public class DecisionsActivityViewImpl extends AppCompatActivity implements IDecisionActiviyView {

    ListView decisionsListView;
    List<DecisionsDataModel> listOfDecisionsData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decisions);

        initDecisionsActivityComponent();
        fillDecisionListViewData();
        bindListView2Adapter();
        clickDecisionsListViewItem();

    }

    @Override
    public void initDecisionsActivityComponent() {
        getSupportActionBar().hide();

        decisionsListView = (ListView) findViewById(R.id.decisionsListView);
    }

    @Override
    public void fillDecisionListViewData() {
        listOfDecisionsData = new ArrayList<>();
        listOfDecisionsData.add(new DecisionsDataModel(R.drawable.decisions_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDecisionsData.add(new DecisionsDataModel(R.drawable.decisions_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDecisionsData.add(new DecisionsDataModel(R.drawable.decisions_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDecisionsData.add(new DecisionsDataModel(R.drawable.decisions_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDecisionsData.add(new DecisionsDataModel(R.drawable.decisions_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDecisionsData.add(new DecisionsDataModel(R.drawable.decisions_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDecisionsData.add(new DecisionsDataModel(R.drawable.decisions_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDecisionsData.add(new DecisionsDataModel(R.drawable.decisions_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));

    }

    @Override
    public void bindListView2Adapter() {
        DecisionsListViewAdapter documentsListViewAdapter = new DecisionsListViewAdapter(getApplicationContext(),listOfDecisionsData);
        decisionsListView.setAdapter(documentsListViewAdapter);
    }

    @Override
    public void clickDecisionsListViewItem() {
        decisionsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(), DecisionDetailActivityImpl.class));
            }
        });
    }
}
