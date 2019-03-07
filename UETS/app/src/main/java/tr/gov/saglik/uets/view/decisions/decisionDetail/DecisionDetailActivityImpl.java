package tr.gov.saglik.uets.view.decisions.decisionDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import tr.gov.saglik.uets.R;

public class DecisionDetailActivityImpl extends AppCompatActivity implements IDecisionDetailActivityView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decisions_detail);

        getSupportActionBar().hide();
    }
}
