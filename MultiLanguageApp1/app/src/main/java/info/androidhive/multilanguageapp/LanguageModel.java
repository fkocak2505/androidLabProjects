package info.androidhive.multilanguageapp;

import android.content.Context;
import android.content.res.Configuration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import info.androidhive.multilanguageapp.common.MLanguageHelper;

public class LanguageModel extends MLanguageHelper {

    @Override
    public MLanguageResultModel changeLanguage(Context context, String language) {
        Map<Boolean, String> resultMap = new HashMap<>();
        if (language.trim().equals("") || language == null){

            return new MLanguageResultModel(false,"Dil değişmedi");
        }

        Locale appLoc = new Locale(language);
        Locale.setDefault(appLoc);
        Configuration appConfig = new Configuration();
        appConfig.locale = appLoc;
        context.getResources().updateConfiguration(appConfig,
                context.getResources().getDisplayMetrics());

        return new MLanguageResultModel(true,"Dil Değişti..");
    }
}
