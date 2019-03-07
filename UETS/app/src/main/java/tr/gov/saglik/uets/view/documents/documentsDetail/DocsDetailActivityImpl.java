package tr.gov.saglik.uets.view.documents.documentsDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import tr.gov.saglik.uets.R;

public class DocsDetailActivityImpl extends AppCompatActivity implements IDocsDetailActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents_detail);

        getSupportActionBar().hide();
    }
}
