package tr.gov.saglik.uets.view.demandsDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.view.demands.adapter.ViewPagerAdapter;
import tr.gov.saglik.uets.view.demandsDetail.fragment.DemandItemDetailFragmentViewImpl;
import tr.gov.saglik.uets.view.demandsDetail.fragment.DemandItemInfoFragmentViewImpl;

public class DemandsDetailActivityViewImpl extends AppCompatActivity implements IDemandsDetailActivityView {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demands_detail);

        setToolbarConfig();
        initDemandsActivityComponent();
    }


    @Override
    public void setToolbarConfig() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initDemandsActivityComponent() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DemandItemInfoFragmentViewImpl(), getResources().getString(R.string.demandsDetailInfo));
        adapter.addFragment(new DemandItemDetailFragmentViewImpl(), getResources().getString(R.string.demandsDetial));
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
}
