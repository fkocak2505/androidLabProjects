package tr.gov.saglik.uets.view.documents;

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
import tr.gov.saglik.uets.model.documents.dataModel.DocumentsDataModel;
import tr.gov.saglik.uets.view.documents.adapter.DocumentsListViewAdapter;
import tr.gov.saglik.uets.view.documents.documentsDetail.DocsDetailActivityImpl;

public class DocumentsActivityViewImpl extends AppCompatActivity implements IDocumentsActivityView {

    ListView docsListView;
    List<DocumentsDataModel> listOfDocumentsData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);

        initDocumentsActivityComponent();
        fillDocsListViewData();
        bindListView2Adapter();
        clickDocumentsListViewItem();

    }

    @Override
    public void initDocumentsActivityComponent() {
        getSupportActionBar().hide();

        docsListView = (ListView) findViewById(R.id.docsListView);
    }

    @Override
    public void fillDocsListViewData() {
        listOfDocumentsData = new ArrayList<>();
        listOfDocumentsData.add(new DocumentsDataModel(R.drawable.documents_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDocumentsData.add(new DocumentsDataModel(R.drawable.documents_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDocumentsData.add(new DocumentsDataModel(R.drawable.documents_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDocumentsData.add(new DocumentsDataModel(R.drawable.documents_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDocumentsData.add(new DocumentsDataModel(R.drawable.documents_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDocumentsData.add(new DocumentsDataModel(R.drawable.documents_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDocumentsData.add(new DocumentsDataModel(R.drawable.documents_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
        listOfDocumentsData.add(new DocumentsDataModel(R.drawable.documents_icon,"Form 22 Uzmanlık Öğrencisi Kontenjan Talep Formu (YDUS)","04/03/2019"));
    }

    @Override
    public void bindListView2Adapter() {
        DocumentsListViewAdapter documentsListViewAdapter = new DocumentsListViewAdapter(getApplicationContext(),listOfDocumentsData);
        docsListView.setAdapter(documentsListViewAdapter);
    }

    @Override
    public void clickDocumentsListViewItem() {
        docsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(), DocsDetailActivityImpl.class));
            }
        });
    }
}
