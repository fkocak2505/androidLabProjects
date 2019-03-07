package tr.gov.saglik.uets.view.studentsReport.bitirmeSinavi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import tr.gov.saglik.uets.R;

public class BitirmeSinaviActivityViewImpl extends AppCompatActivity implements IBitirmeSinaviActivityView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sr_bitirme_sinavi);
    }
}
