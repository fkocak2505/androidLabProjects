package tr.com.fkocak.settingpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.Toast;

/**
 * Created by fatihkocak on 4.10.2018.
 */

public class SettingsActivity extends AppCompatPreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // load settings fragment
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MainPreferenceFragment()).commit();
    }

    public static class MainPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_main);

            ///// General Setting

            ListPreference listPreferenceLanguage4From = (ListPreference) findPreference("listPreferenceLanguage4From");
            CharSequence currText4From = listPreferenceLanguage4From.getEntry();
            String currValue4From = listPreferenceLanguage4From.getValue();
            listPreferenceLanguage4From.setSummary(currText4From);

            ListPreference listPreferenceLanguage4To = (ListPreference) findPreference("listPreferenceLanguage4To");
            CharSequence currText4To = listPreferenceLanguage4To.getEntry();
            String currValue4To = listPreferenceLanguage4To.getValue();
            listPreferenceLanguage4To.setSummary(currText4To);


            CustomSwitchPreference switchPreference4SavedText = (CustomSwitchPreference) findPreference("saveEnteredAndTranslatedText");
            /*if (switchPreference4SavedText.isChecked())
                Toast.makeText(getActivity().getApplicationContext(), "saveEnteredAndTranslatedText Yes", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getActivity().getApplicationContext(), "saveEnteredAndTranslatedText No..", Toast.LENGTH_SHORT).show();*/

            ///// Notification Setting
            CustomSwitchPreference switchPreference4AllowNotification = (CustomSwitchPreference) findPreference("isNotification");
            /*if (switchPreference4AllowNotification.isChecked())
                Toast.makeText(getActivity().getApplicationContext(), "isNotification Yes", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getActivity().getApplicationContext(), "isNotification No..", Toast.LENGTH_SHORT).show();*/


            bindPreference4List(getActivity().getApplicationContext(), (ListPreference) findPreference("listPreferenceLanguage4From"));
            bindPreference4List(getActivity().getApplicationContext(), (ListPreference) findPreference("listPreferenceLanguage4To"));
            bindPreference4Switch(getActivity().getApplicationContext(), (CustomSwitchPreference) findPreference("saveEnteredAndTranslatedText"));
            bindPreference4Switch(getActivity().getApplicationContext(), (CustomSwitchPreference) findPreference("isNotification"));


            Preference myPref = findPreference("sendFeedBack");
            myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    sendFeedback(getActivity());
                    return true;
                }
            });

        }
    }


    public static void sendFeedback(Context context) {
        String body = null;
        try {
            body = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            body = "\n\n-----------------------------\nBu bilgiler görüşleriniz için önemlidir\nLütfen silmeyiniz\n Cihaz İşletim Sistemi: Android \n İşletim Sistemi Version: " +
                    Build.VERSION.RELEASE + "\n Uygulama Versiyonu: " + body + "\n Cihaz Markası: " + Build.BRAND +
                    "\n Cihaz Modeli: " + Build.MODEL + "\n Cihaz Üretici Bilgisi: " + Build.MANUFACTURER;
        } catch (PackageManager.NameNotFoundException e) {
        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"fkocak2505@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "ByTranslator Uygulaması Görüş");
        intent.putExtra(Intent.EXTRA_TEXT, body);
        context.startActivity(Intent.createChooser(intent, "Choose email client"));
    }


    private static void bindPreference4List(final Context context, final ListPreference listPreference) {
        listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                int index = listPreference.findIndexOfValue(newValue.toString());

                if (index != -1) {
                    Toast.makeText(context, listPreference.getEntries()[index] + " olarak ayarlandı", Toast.LENGTH_LONG).show();
                    preference.setSummary(listPreference.getEntries()[index]);
                }
                return true;
            }
        });
    }

    private static void bindPreference4Switch(final Context context, final CustomSwitchPreference switchPreference) {

        switchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference arg0, Object isVibrateOnObject) {
                boolean isSwitch = (Boolean) isVibrateOnObject;
                /*if (isSwitch) Toast.makeText(context, "açıldı", Toast.LENGTH_SHORT).show();
                else Toast.makeText(context, "Kapandı", Toast.LENGTH_SHORT).show();*/
                return true;
            }
        });
    }

}
