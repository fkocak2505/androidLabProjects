package tr.gov.saglik.uets.view.demands;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.NonScrollableViewPager;
import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.demands.dataModel.NaviationMenuDataModel;
import tr.gov.saglik.uets.view.announcements.AnnouncementsActivityViewImpl;
import tr.gov.saglik.uets.view.curriculum.CurriculumActivityViewImpl;
import tr.gov.saglik.uets.view.decisions.DecisionsActivityViewImpl;
import tr.gov.saglik.uets.view.demands.adapter.NavMenuListViewAdapter;
import tr.gov.saglik.uets.view.demands.adapter.ViewPagerAdapter;
import tr.gov.saglik.uets.view.demands.fragment.complated.ComplatedFragmentViewImpl;
import tr.gov.saglik.uets.view.demands.fragment.pendingApprovel.PendingApprovelFragmentViewImpl;
import tr.gov.saglik.uets.view.documents.DocumentsActivityViewImpl;
import tr.gov.saglik.uets.view.notifications.NotificationsActivityViewImpl;
import tr.gov.saglik.uets.view.profil.ProfilActivityViewImpl;
import tr.gov.saglik.uets.view.programs.ProgramsActivityViewImpl;
import tr.gov.saglik.uets.view.studentsReport.StudentReportActivityViewImpl;

public class DemandsActivityViewImpl extends AppCompatActivity
        implements IDemandsActivityView {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private NonScrollableViewPager viewPager;

    private List<NaviationMenuDataModel> menuItem = new ArrayList<>();
    private ListView listView;
    private NavMenuListViewAdapter navMenuListViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demands);

        // Toolbar Config
        setToolbarConfig();
        initDemandsActivityComponent();

        // Change After
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void setToolbarConfig() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initDemandsActivityComponent() {

        listView = (ListView) findViewById(R.id.list_view_inside_nav);
        fillNavigationMenu();

        viewPager = (NonScrollableViewPager) findViewById(R.id.viewpager);
        //viewPager.disableScroll(true); /// View Pager is Disabled
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void fillNavigationMenu() {
        menuItem.add(new NaviationMenuDataModel(R.drawable.ic_launcher_background, "Ana Sayfa", "0", 0, false, false));
        menuItem.add(new NaviationMenuDataModel(R.drawable.ic_launcher_background, "Programlar", "0", 0, false, false));
        menuItem.add(new NaviationMenuDataModel(R.drawable.ic_launcher_background, "Dökümanlar", "0", 0, false, false));
        menuItem.add(new NaviationMenuDataModel(R.drawable.ic_launcher_background, "Karne", "0", 0, false, false));
        menuItem.add(new NaviationMenuDataModel(R.drawable.ic_launcher_background, "Duyurular", "12", R.drawable.nav_item_detail_icon, true, true));
        menuItem.add(new NaviationMenuDataModel(R.drawable.ic_launcher_background, "Kararlar", "0", 0, false, false));
        menuItem.add(new NaviationMenuDataModel(R.drawable.ic_launcher_background, "Bildirimler", "0", 0, false, false));
        menuItem.add(new NaviationMenuDataModel(R.drawable.ic_launcher_background, "Müfredatlar", "0", 0, false, false));
        menuItem.add(new NaviationMenuDataModel(R.drawable.ic_launcher_background, "Profil", "0", 0, false, false));
        menuItem.add(new NaviationMenuDataModel(R.drawable.ic_launcher_background, "İletişim", "0", 0, false, false));


        navMenuListViewAdapter = new NavMenuListViewAdapter(this, menuItem);
        listView.setAdapter(navMenuListViewAdapter);

        clickMenuItem();

    }

    @Override
    public void clickMenuItem() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (menuItem.get(position).getItemName()){
                    case "Ana Sayfa":
                        break;
                    case "Programlar":
                        startActivity(new Intent(getApplicationContext(), ProgramsActivityViewImpl.class));
                        break;
                    case "Dökümanlar":
                        startActivity(new Intent(getApplicationContext(), DocumentsActivityViewImpl.class));
                        break;
                    case "Karne":
                        startActivity(new Intent(getApplicationContext(), StudentReportActivityViewImpl.class));
                        break;
                    case "Duyurular":
                        startActivity(new Intent(getApplicationContext(), AnnouncementsActivityViewImpl.class));
                        break;
                    case "Kararlar":
                        startActivity(new Intent(getApplicationContext(), DecisionsActivityViewImpl.class));
                        break;
                    case "Bildirimler":
                        startActivity(new Intent(getApplicationContext(), NotificationsActivityViewImpl.class));
                        break;
                    case "Müfredatlar":
                        startActivity(new Intent(getApplicationContext(), CurriculumActivityViewImpl.class));
                        break;
                    case "Profil":
                        startActivity(new Intent(getApplicationContext(), ProfilActivityViewImpl.class));
                        break;
                    case "İletişim":
                        Toast.makeText(DemandsActivityViewImpl.this, menuItem.get(position).getItemName() + "clicked", Toast.LENGTH_SHORT).show();
                        break;
                }



                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PendingApprovelFragmentViewImpl(), getResources().getString(R.string.demandsPendingApprovelText));
        adapter.addFragment(new ComplatedFragmentViewImpl(), getResources().getString(R.string.demandsCompleted));
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
