package tr.gov.saglik.uets.view.announcements;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.announcements.AnnouncementsDataModel;
import tr.gov.saglik.uets.view.announcements.adapter.AnnouncementsListViewAdapter;

public class AnnouncementsActivityViewImpl extends AppCompatActivity implements IAnnouncementActivityView {

    ListView announcementsListView;
    List<AnnouncementsDataModel> listOfAnnouncementData;
    AnnouncementsListViewAdapter announcementsListViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        initWelcomeActivityComponent();
        fillNotificationListViewData();

    }

    @Override
    public void initWelcomeActivityComponent() {
        getSupportActionBar().hide();
        announcementsListView = (ListView) findViewById(R.id.announcementsListView);
    }

    @Override
    public void fillNotificationListViewData() {
        listOfAnnouncementData = new ArrayList<>();
        listOfAnnouncementData.add(new AnnouncementsDataModel(R.drawable.ic_launcher_background,"Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.","01/03/2019"));
        listOfAnnouncementData.add(new AnnouncementsDataModel(R.drawable.ic_launcher_background,"Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.","01/03/2019"));
        listOfAnnouncementData.add(new AnnouncementsDataModel(R.drawable.ic_launcher_background,"Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.","01/03/2019"));
        listOfAnnouncementData.add(new AnnouncementsDataModel(R.drawable.ic_launcher_background,"Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.","01/03/2019"));
        listOfAnnouncementData.add(new AnnouncementsDataModel(R.drawable.ic_launcher_background,"Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.","01/03/2019"));
        listOfAnnouncementData.add(new AnnouncementsDataModel(R.drawable.ic_launcher_background,"Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.","01/03/2019"));
        listOfAnnouncementData.add(new AnnouncementsDataModel(R.drawable.ic_launcher_background,"Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.","01/03/2019"));
        listOfAnnouncementData.add(new AnnouncementsDataModel(R.drawable.ic_launcher_background,"Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.","01/03/2019"));

        announcementsListViewAdapter = new AnnouncementsListViewAdapter(getApplicationContext(),listOfAnnouncementData);
        announcementsListView.setAdapter(announcementsListViewAdapter);

    }
}
