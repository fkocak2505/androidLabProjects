package tr.gov.saglik.uets.view.profil.demandsRecommendations;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.profil.demandsRecommendation.dataModel.DemandsRecommendationDataModel;
import tr.gov.saglik.uets.view.profil.demandsRecommendations.adapter.DemandsRecommendationListViewAdapter;

public class DemandsAndRecommendationsActivityViewImpl extends AppCompatActivity
        implements IDemandsAndRecommendationsActivityView {

    ListView demandsRecommendationListView;
    List<DemandsRecommendationDataModel> listOfDemandsRecommandationData;
    FloatingActionButton fabDemandsRecommendation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demands_recommendations);

        initWelcomeActivityComponent();
        fillDemandsRecommendationListViewData();
        bindDemandsRecommendationData2Adapter();

        clickAddDemandsRecommendation();

    }

    @Override
    public void clickAddDemandsRecommendation() {
        fabDemandsRecommendation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NewDemandsAndRecommendationActivityViewImpl.class));
            }
        });
    }

    @Override
    public void initWelcomeActivityComponent() {
        getSupportActionBar().hide();

        demandsRecommendationListView = (ListView) findViewById(R.id.demandsRecommendationListView);
        fabDemandsRecommendation = (FloatingActionButton) findViewById(R.id.fabAddDemandsRecommendation);
    }

    @Override
    public void fillDemandsRecommendationListViewData() {
        listOfDemandsRecommandationData = new ArrayList<>();
        listOfDemandsRecommandationData.add(new DemandsRecommendationDataModel("1111111111", "Öneri", "Kanaat Notları", "TUK Sekretaryası", "-", "05/03/2019", "İletildi"));
        listOfDemandsRecommandationData.add(new DemandsRecommendationDataModel("1111111111", "Öneri", "Kanaat Notları", "TUK Sekretaryası", "-", "05/03/2019", "İletildi"));
        listOfDemandsRecommandationData.add(new DemandsRecommendationDataModel("1111111111", "Öneri", "Kanaat Notları", "TUK Sekretaryası", "-", "05/03/2019", "İletildi"));

    }

    @Override
    public void bindDemandsRecommendationData2Adapter() {
        DemandsRecommendationListViewAdapter demandsRecommendationListViewAdapter = new DemandsRecommendationListViewAdapter(getApplicationContext(), listOfDemandsRecommandationData);
        demandsRecommendationListView.setAdapter(demandsRecommendationListViewAdapter);
    }
}
