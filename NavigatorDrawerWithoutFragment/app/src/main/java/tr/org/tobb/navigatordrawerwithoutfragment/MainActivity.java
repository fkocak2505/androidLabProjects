package tr.org.tobb.navigatordrawerwithoutfragment;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    Toolbar toolbar;

    String menuItem[] = {"Ana Ekran", "Bildirimler", "Firma Detay", "Üye Sorgula", "Oda / Borsa Bul", "Görüş Bildir", "Hakkımızda", "Çıkış"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Dashboard");

        setData4LeftMenu();
        setDrawerBehaviour();
    }



    public void setData4LeftMenu(){
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new LeftMenuAdapter(menuItem);
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        selectedItem(position);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(MainActivity.this, " " + position, Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }

    public void setDrawerBehaviour(){
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };
        drawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }


    void selectedItem(int position) {
        if (position == 1) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, " " + position, Toast.LENGTH_SHORT).show();
        }
        if (position == 2) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, " " + position, Toast.LENGTH_SHORT).show();
        }
        if (position == 3) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, " " + position, Toast.LENGTH_SHORT).show();
        }
        if (position == 4) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, " " + position, Toast.LENGTH_SHORT).show();
        }
        if (position == 5) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, " " + position, Toast.LENGTH_SHORT).show();
        }
        if (position == 6) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, " " + position, Toast.LENGTH_SHORT).show();
        }
        if (position == 7) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, " " + position, Toast.LENGTH_SHORT).show();
        }
        if (position == 8) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, " " + position, Toast.LENGTH_SHORT).show();
        }
    }

}
