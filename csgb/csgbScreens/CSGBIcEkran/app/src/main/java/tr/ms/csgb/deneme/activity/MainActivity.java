package tr.ms.csgb.deneme.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tr.ms.csgb.deneme.GenericClass;
import tr.ms.csgb.deneme.data_model.ListViewItemModel;
import tr.ms.csgb.deneme.adapter.NavMenuListViewAdapter;
import tr.ms.csgb.deneme.R;
import tr.ms.csgb.deneme.fragment.FourFragment;
import tr.ms.csgb.deneme.fragment.OneFragment;
import tr.ms.csgb.deneme.fragment.ThreeFragment;
import tr.ms.csgb.deneme.fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<ListViewItemModel> menuItem = new ArrayList<>();
    private ListView listView;
    private NavMenuListViewAdapter navMenuListViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getResources().getString(R.string.homeFragmentName));

        listView = (ListView) findViewById(R.id.list_view_inside_nav);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showErrorConnection();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        menuItem.add(new ListViewItemModel(R.drawable.nav_item_home, "Ana Sayfa", "0", 0, false, false));
        menuItem.add(new ListViewItemModel(R.drawable.nav_item_appeals, "Başvurular", "0", R.drawable.nav_item_detail_icon, false, true));
        menuItem.add(new ListViewItemModel(R.drawable.nav_item_announcement, "Duyurular", "12", R.drawable.nav_item_detail_icon, true, true));
        menuItem.add(new ListViewItemModel(R.drawable.nav_item_calendar, "Takvim", "0", R.drawable.nav_item_detail_icon, false, true));
        menuItem.add(new ListViewItemModel(R.drawable.nav_item_contract, "Sözleşmeler", "0", 0, false, false));
        menuItem.add(new ListViewItemModel(R.drawable.nav_item_auth_doc, "Yetki Belgesi", "0", 0, false, false));
        menuItem.add(new ListViewItemModel(R.drawable.nav_item_contract, "İletişim", "0", 0, false, false));
        menuItem.add(new ListViewItemModel(R.drawable.nav_item_faq, "Sıkça Sorulan Sorular", "0", 0, false, false));
        menuItem.add(new ListViewItemModel(R.drawable.nav_item_come_from_you, "Sizden Gelenler", "0", 0, false, false));


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        //navigationView.setNavigationItemSelectedListener(this);

        navMenuListViewAdapter = new NavMenuListViewAdapter(this, menuItem);
        listView.setAdapter(navMenuListViewAdapter);

        clickMenuItem();

    }

    public void clickMenuItem() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, menuItem.get(position).getItemName() + "clicked", Toast.LENGTH_SHORT).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
    }

    private void setupTabIcons() {
        int[] tabIcons = {
                R.drawable.dashboard_home,
                R.drawable.dashboard_notification,
                R.drawable.dashboard_messages,
                R.drawable.dashboard_profile
        };

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "ONE");
        adapter.addFragment(new TwoFragment(), "TWO");
        adapter.addFragment(new ThreeFragment(), "THREE");
        adapter.addFragment(new FourFragment(), "Four");
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        toolbar.setTitle(getResources().getString(R.string.homeFragmentName));
                        break;
                    case 1:
                        toolbar.setTitle(getResources().getString(R.string.notificationFragmentName));
                        break;
                    case 2:
                        toolbar.setTitle(getResources().getString(R.string.messagesFragmentName));
                        break;
                    case 3:
                        toolbar.setTitle(getResources().getString(R.string.profileFragmentName));
                        break;
                }
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //return mFragmentTitleList.get(position);
            return null;
        }
    }

    public void showErrorConnection() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View convertView = (View) inflater.inflate(R.layout.no_connection, null);
        alertDialog.setView(convertView);

        final AlertDialog dialog = alertDialog.create();

        TextView tryConnectAgain = (TextView) convertView.findViewById(R.id.tryConnectAgain);
        tryConnectAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*finish();
                startActivity(getIntent());*/
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
