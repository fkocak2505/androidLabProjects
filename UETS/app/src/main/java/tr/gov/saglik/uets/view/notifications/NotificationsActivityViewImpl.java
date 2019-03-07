package tr.gov.saglik.uets.view.notifications;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.notifcations.dataModel.NotificationDataModel;
import tr.gov.saglik.uets.view.notifications.adapter.NotificationListViewAdapter;

public class NotificationsActivityViewImpl extends AppCompatActivity implements INotificationActivityView {

    ConstraintLayout noNotificationLayout;
    ConstraintLayout notificationLayout;

    ListView notificationListView;
    List<NotificationDataModel> listOfNotificationDataModel;
    NotificationListViewAdapter notificationListViewAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        initWelcomeActivityComponent();
        fillNotificationListViewData();

    }

    @Override
    public void initWelcomeActivityComponent() {
        getSupportActionBar().hide();

        noNotificationLayout = (ConstraintLayout) findViewById(R.id.noNotificationLayout);
        notificationLayout = (ConstraintLayout) findViewById(R.id.notificationLayout);
        notificationListView = (ListView) findViewById(R.id.notificationListView);

    }

    @Override
    public void fillNotificationListViewData() {
        listOfNotificationDataModel = new ArrayList<>();
        listOfNotificationDataModel.add(new NotificationDataModel("Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.", "22/11/2018"));
        listOfNotificationDataModel.add(new NotificationDataModel("Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.", "22/11/2018"));
        listOfNotificationDataModel.add(new NotificationDataModel("Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.", "22/11/2018"));
        listOfNotificationDataModel.add(new NotificationDataModel("Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.", "22/11/2018"));
        listOfNotificationDataModel.add(new NotificationDataModel("Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.", "22/11/2018"));
        listOfNotificationDataModel.add(new NotificationDataModel("Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.", "22/11/2018"));
        listOfNotificationDataModel.add(new NotificationDataModel("Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.", "22/11/2018"));
        listOfNotificationDataModel.add(new NotificationDataModel("Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.", "22/11/2018"));
        listOfNotificationDataModel.add(new NotificationDataModel("Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.", "22/11/2018"));
        listOfNotificationDataModel.add(new NotificationDataModel("Tıpta Uzmanlık Kurulu tarafından kabul edilmiş Uzmanlık Eğitimi Programları listesi güncellenmiştir.", "22/11/2018"));

        notificationListViewAdapter = new NotificationListViewAdapter(getApplicationContext(), listOfNotificationDataModel);
        notificationListView.setAdapter(notificationListViewAdapter);

    }
}
