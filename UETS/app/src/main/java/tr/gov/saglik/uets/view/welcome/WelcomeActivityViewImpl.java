package tr.gov.saglik.uets.view.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.model.welcome.WelcomeActivityModelImpl;
import tr.gov.saglik.uets.presenter.welcome.WelcomeActivityPresenterImpl;
import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.welcome.dataModel.WelcomeMenuDataModel;
import tr.gov.saglik.uets.view.announcements.AnnouncementsActivityViewImpl;
import tr.gov.saglik.uets.view.curriculum.CurriculumActivityViewImpl;
import tr.gov.saglik.uets.view.decisions.DecisionsActivityViewImpl;
import tr.gov.saglik.uets.view.documents.DocumentsActivityViewImpl;
import tr.gov.saglik.uets.view.login.LoginActivityViewImpl;
import tr.gov.saglik.uets.view.programs.ProgramsActivityViewImpl;
import tr.gov.saglik.uets.view.register.RegisterActivityViewImpl;
import tr.gov.saglik.uets.view.welcome.adapter.WelcomeActivityCustomGridAdapter;

public class WelcomeActivityViewImpl extends AppCompatActivity implements IWelcomeActivityView {

    WelcomeActivityPresenterImpl welcomeActivityPresenterImpl;

    GridView welcomeMenu;
    WelcomeActivityCustomGridAdapter welcomeActivityCustomGridAdapter;
    Button loginBtn;
    Button registerBtn;

    List<WelcomeMenuDataModel> listOfWelcomeMenuMenuData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();

        initWelcomeActivityComponent();
        setWelcomeGridMenuData();

        welcomeActivityPresenterImpl = new WelcomeActivityPresenterImpl(new WelcomeActivityModelImpl(), this);



    }

    @Override
    public void initWelcomeActivityComponent() {
        welcomeMenu = (GridView) findViewById(R.id.welcomeMenu);
        loginBtn = (Button) findViewById(R.id.welcomeLoginBtn);
        registerBtn = (Button) findViewById(R.id.welcomeRegisterBtn);

        listOfWelcomeMenuMenuData = new ArrayList<>();
        listOfWelcomeMenuMenuData.add(new WelcomeMenuDataModel(R.drawable.welcome_activity_programs,"Programlar"));
        listOfWelcomeMenuMenuData.add(new WelcomeMenuDataModel(R.drawable.welcome_activity_announcement,"Duyurular"));
        listOfWelcomeMenuMenuData.add(new WelcomeMenuDataModel(R.drawable.welcome_activity_curriculum,"Müfredatlar"));
        listOfWelcomeMenuMenuData.add(new WelcomeMenuDataModel(R.drawable.welcome_activity_documents,"Dökümanlar"));
        listOfWelcomeMenuMenuData.add(new WelcomeMenuDataModel(R.drawable.welcome_activity_decision,"Kararlar"));
        listOfWelcomeMenuMenuData.add(new WelcomeMenuDataModel(R.drawable.welcome_activity_communucation,"İletişim"));
    }

    @Override
    public void setWelcomeGridMenuData() {
        welcomeActivityCustomGridAdapter = new WelcomeActivityCustomGridAdapter(getApplicationContext(),listOfWelcomeMenuMenuData);
        welcomeMenu.setAdapter(welcomeActivityCustomGridAdapter);

        welcomeMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //welcomeActivityPresenterImpl.getSelectedData(listOfWelcomeMenuMenuData.get(position).getWelcomeMenuItemTitle());
                switch (listOfWelcomeMenuMenuData.get(position).getWelcomeMenuItemTitle()){
                    case "Programlar":
                        startActivity(new Intent(getApplicationContext(), ProgramsActivityViewImpl.class));
                        break;
                    case "Duyurular":
                        startActivity(new Intent(getApplicationContext(), AnnouncementsActivityViewImpl.class));
                        break;
                    case "Müfredatlar":
                        startActivity(new Intent(getApplicationContext(), CurriculumActivityViewImpl.class));
                        break;
                    case "Dökümanlar":
                        startActivity(new Intent(getApplicationContext(), DocumentsActivityViewImpl.class));
                        break;
                    case "Kararlar":
                        startActivity(new Intent(getApplicationContext(), DecisionsActivityViewImpl.class));
                        break;
                    case "İletişim":
                        Toast.makeText(WelcomeActivityViewImpl.this, "İletişim", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void goLogin(View view) {
        startActivity(new Intent(getApplicationContext(),LoginActivityViewImpl.class));
    }

    @Override
    public void goRegister(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterActivityViewImpl.class));
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "Progress Starting", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading(String messages) {
        Toast.makeText(this, messages + " tıklandı", Toast.LENGTH_SHORT).show();
    }

}
