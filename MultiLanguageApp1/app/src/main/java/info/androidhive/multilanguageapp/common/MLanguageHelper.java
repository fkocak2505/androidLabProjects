package info.androidhive.multilanguageapp.common;

import android.content.Context;

import java.util.Map;

import info.androidhive.multilanguageapp.MLanguageResultModel;

public abstract class MLanguageHelper {


    private Context context;
    private String language;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public abstract MLanguageResultModel changeLanguage(Context context, String language);
}
