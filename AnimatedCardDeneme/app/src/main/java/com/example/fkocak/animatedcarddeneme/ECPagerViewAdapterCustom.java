package com.example.fkocak.animatedcarddeneme;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;


public abstract class ECPagerViewAdapterCustom extends PagerAdapter {

    private ECPagerCardCustom activeCard;
    private List<ECCardDataCustom> dataset;
    private LayoutInflater inflaterService;

    public ECPagerViewAdapterCustom(Context applicationContext, List<ECCardDataCustom> dataset) {
        this.inflaterService = (LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.dataset = dataset;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final ECPagerCustom pager = (ECPagerCustom) container;
        final ECPagerCardCustom pagerCard = (ECPagerCardCustom) inflaterService.inflate(R.layout.ec_pager_card_custom, null);
        final ECPagerViewCustom pagerContainer = (ECPagerViewCustom) pager.getParent();

        ECPagerCardContentListCustom ecPagerCardContentList = pagerCard.getEcPagerCardContentList();
        ECPagerCardHeadCustom headView = ecPagerCardContentList.getHeadView();

        headView.setHeight(pagerContainer.getCardHeight());

        Integer drawableRes = dataset.get(position).getHeadBackgroundResource();
        if (drawableRes != null) {
            headView.setHeadImageBitmap(BitmapFactory.decodeResource(pagerContainer.getResources(), drawableRes, new BitmapFactoryOptions()));
        }

        instantiateCard(inflaterService, headView, ecPagerCardContentList, dataset.get(position));

        pager.addView(pagerCard, pagerContainer.getCardWidth(), pagerContainer.getCardHeight());
        return pagerCard;
    }


    public abstract void instantiateCard(LayoutInflater inflaterService, ViewGroup head, ListView list, ECCardDataCustom data);

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        activeCard = (ECPagerCardCustom) object;
    }

    public ECPagerCardCustom getActiveCard() {
        return activeCard;
    }

    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    public List<ECCardDataCustom> getDataset() {
        return dataset;
    }
}
