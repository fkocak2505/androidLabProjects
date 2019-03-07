package tr.gov.saglik.uets.view.studentsReport;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.studentReport.dataModel.StudentReportGridDataModel;
import tr.gov.saglik.uets.model.welcome.dataModel.WelcomeMenuDataModel;
import tr.gov.saglik.uets.view.studentsReport.adapter.StudentReportGridViewAdapter;
import tr.gov.saglik.uets.view.studentsReport.bitirmeSinavi.BitirmeSinaviActivityViewImpl;

public class StudentReportActivityViewImpl extends AppCompatActivity implements IStudentReportActivityView {

    GridView studentReportGridView;
    List<StudentReportGridDataModel> listOfStudentReportGridData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_report);

        initStudentReportActivityComponent();
        fillDocsListViewData();
        bindListView2Adapter();
        clickDocumentsListViewItem();
    }

    @Override
    public void initStudentReportActivityComponent() {
        getSupportActionBar().hide();

        studentReportGridView = (GridView) findViewById(R.id.studentReportGridView);
    }

    @Override
    public void fillDocsListViewData() {
        listOfStudentReportGridData = new ArrayList<>();
        listOfStudentReportGridData.add(new StudentReportGridDataModel(R.drawable.sr_program_info,"Program Bilgileri"));
        listOfStudentReportGridData.add(new StudentReportGridDataModel(R.drawable.sr_rotation,"Rotasyon Bilgileri"));
        listOfStudentReportGridData.add(new StudentReportGridDataModel(R.drawable.sr_entrusting,"Görevlendirme Bilgileri"));
        listOfStudentReportGridData.add(new StudentReportGridDataModel(R.drawable.sr_transport,"Nakil Bilgileri"));
        listOfStudentReportGridData.add(new StudentReportGridDataModel(R.drawable.sr_yetkinlik,"Yetkinlik Bilgileri"));
        listOfStudentReportGridData.add(new StudentReportGridDataModel(R.drawable.sr_thesis,"Tez Bilgileri"));
        listOfStudentReportGridData.add(new StudentReportGridDataModel(R.drawable.sr_bitirme_sinavi,"Bitirme Sınavı Bilgileri"));
    }

    @Override
    public void bindListView2Adapter() {
        StudentReportGridViewAdapter studentReportGridViewAdapter = new StudentReportGridViewAdapter(getApplicationContext(),listOfStudentReportGridData);
        studentReportGridView.setAdapter(studentReportGridViewAdapter);
    }

    @Override
    public void clickDocumentsListViewItem() {
        studentReportGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (listOfStudentReportGridData.get(position).getStudentReportGridItemTitle()){
                    case "Program Bilgileri":
                    case "Rotasyon Bilgileri":
                    case "Görevlendirme Bilgileri":
                    case "Nakil Bilgileri":
                    case "Yetkinlik Bilgileri":
                    case "Tez Bilgileri":
                        Toast.makeText(StudentReportActivityViewImpl.this, "Tıklandı", Toast.LENGTH_SHORT).show();
                        break;
                    case "Bitirme Sınavı Bilgileri":
                        startActivity(new Intent(getApplicationContext(), BitirmeSinaviActivityViewImpl.class));
                        break;
                }
            }
        });
    }
}
