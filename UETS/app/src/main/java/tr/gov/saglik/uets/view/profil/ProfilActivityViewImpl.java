package tr.gov.saglik.uets.view.profil;

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
import tr.gov.saglik.uets.model.profil.dataModel.ProfilSettingDataModel;
import tr.gov.saglik.uets.view.profil.adapter.ProfilSettingDataListViewAdapter;
import tr.gov.saglik.uets.view.profil.demandsRecommendations.DemandsAndRecommendationsActivityViewImpl;
import tr.gov.saglik.uets.view.profil.privacy.PrivacyActivityViewImpl;
import tr.gov.saglik.uets.view.profil.userInfo.UserInfoActivityViewImpl;

public class ProfilActivityViewImpl extends AppCompatActivity implements IProfilActivityView {

    ListView profilSettingListView;
    List<ProfilSettingDataModel> listOfProfilScreenData;
    ProfilSettingDataListViewAdapter profilSettingDataListViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        initWelcomeActivityComponent();
        fillNotificationListViewData();

    }

    @Override
    public void initWelcomeActivityComponent() {
        getSupportActionBar().hide();

        profilSettingListView = (ListView) findViewById(R.id.profilSettingListView);

    }

    @Override
    public void fillNotificationListViewData() {
        listOfProfilScreenData = new ArrayList<>();
        listOfProfilScreenData.add(new ProfilSettingDataModel("Kullanıcı Bilgileri", R.drawable.nav_item_detail_icon));
        listOfProfilScreenData.add(new ProfilSettingDataModel("Talep ve Önerileri", R.drawable.nav_item_detail_icon));
        listOfProfilScreenData.add(new ProfilSettingDataModel("Sıkca Sorulan Sorular", R.drawable.nav_item_detail_icon));
        listOfProfilScreenData.add(new ProfilSettingDataModel("Gizlilik", R.drawable.nav_item_detail_icon));

        profilSettingDataListViewAdapter = new ProfilSettingDataListViewAdapter(getApplicationContext(), listOfProfilScreenData);
        profilSettingListView.setAdapter(profilSettingDataListViewAdapter);


        profilSettingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(getApplicationContext(), UserInfoActivityViewImpl.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), DemandsAndRecommendationsActivityViewImpl.class));
                        break;
                    case 2:
                    case 3:
                        startActivity(new Intent(getApplicationContext(), PrivacyActivityViewImpl.class));
                        break;

                }
            }
        });



    }
}
