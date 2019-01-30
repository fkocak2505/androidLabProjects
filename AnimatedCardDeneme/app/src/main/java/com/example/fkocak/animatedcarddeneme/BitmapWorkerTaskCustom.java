package com.example.fkocak.animatedcarddeneme;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.annotation.DrawableRes;

public class BitmapWorkerTaskCustom extends AsyncTask<Integer, Void, Bitmap> {

    private final Resources mResources;
    private final BackgroundBitmapCacheCustom cache;
    private final int mProvidedBitmapResId;

    public BitmapWorkerTaskCustom(Resources resources, @DrawableRes int providedBitmapResId) {
        this.mResources = resources;
        this.cache = BackgroundBitmapCacheCustom.getInstance();
        this.mProvidedBitmapResId = providedBitmapResId;
    }

    @Override
    protected Bitmap doInBackground(Integer... params) {
        Integer key = params[0];
        Bitmap cachedBitmap = cache.getBitmapFromBgMemCache(key);
        if (cachedBitmap == null) {
            cachedBitmap = BitmapFactory.decodeResource(mResources, mProvidedBitmapResId, new BitmapFactoryOptions());
            cache.addBitmapToBgMemoryCache(key, cachedBitmap);
        }
        return cachedBitmap;
    }


}
