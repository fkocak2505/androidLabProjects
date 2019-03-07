package tr.gov.saglik.uets.view.profil.demandsRecommendations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import tr.gov.saglik.uets.R;

public class NewDemandsAndRecommendationActivityViewImpl extends AppCompatActivity
        implements INewDemandsAndRecommendationActivityView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_demands_recommendation);

        getSupportActionBar().hide();
    }
}
