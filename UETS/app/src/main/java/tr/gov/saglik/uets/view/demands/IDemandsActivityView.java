package tr.gov.saglik.uets.view.demands;

import android.support.v4.view.ViewPager;

public interface IDemandsActivityView {

    void setToolbarConfig();
    void initDemandsActivityComponent();
    void setupViewPager(ViewPager viewPager);
    void fillNavigationMenu();
    void clickMenuItem();

}
