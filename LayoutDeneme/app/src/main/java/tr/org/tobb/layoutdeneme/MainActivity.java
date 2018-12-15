package tr.org.tobb.layoutdeneme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TITLES[] = {"Ana Ekran","Bildirimler","Firma Detay","Üye Sorgula","Görüş Bildir","Hakkımızda","Çıkış"};
    int ICONS[] = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    String NAME = "Akash Bangad";
    String EMAIL = "akash.bangad@android4devs.com";
    int PROFILE = R.mipmap.ic_launcher;

    private Toolbar toolbar;

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");



        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);

        mRecyclerView.setHasFixedSize(true);

        mAdapter = new MyAdapter(TITLES,ICONS,NAME,EMAIL,PROFILE);
        mRecyclerView.setAdapter(mAdapter);

        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);




        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);




        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), mRecyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        selectedItem(position);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Toast.makeText(MainActivity.this, " " + position, Toast.LENGTH_SHORT).show();
                    }
                })
        );

        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }



        };

        Drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    void selectedItem(int position){
        if(position == 1){
            Drawer.closeDrawer(GravityCompat.START);
        }
        if(position == 2){
            Drawer.closeDrawer(GravityCompat.START);
            startActivity(new Intent(getApplicationContext(),Bildirimler.class));
        }
    }

}
