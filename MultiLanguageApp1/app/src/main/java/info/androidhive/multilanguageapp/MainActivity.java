package info.androidhive.multilanguageapp;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends Activity {

	MLanguageResultModel mLanguageResult;
	Button btnChangeLanguage;
	List<String> listOfLanguage = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		listOfLanguage.add("en");
		listOfLanguage.add("es");
		listOfLanguage.add("de");
		listOfLanguage.add("fr");
		listOfLanguage.add("hi");
		listOfLanguage.add("ja");
		listOfLanguage.add("fatih"); /// Türkçe için anlamsız bir değer göndermek yeterli...

		setContentView(R.layout.activity_main);
		getActionBar().hide();


		btnChangeLanguage = (Button) findViewById(R.id.changeLanguage);

		btnChangeLanguage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				changeLanguage();
			}
		});
	}

	public void changeLanguage(){
		String language = listOfLanguage.get(new Random().nextInt(7));

		mLanguageResult = new LanguageModel().changeLanguage(getBaseContext(),language);
		if(mLanguageResult.isChange())
			Toast.makeText(this, "Değişti " + language, Toast.LENGTH_SHORT).show();
		else
			Toast.makeText(this, "Değişmedi " + language, Toast.LENGTH_SHORT).show();
		finish();
		startActivity(getIntent());
	}
}
