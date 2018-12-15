package tr.org.tobb.listviewlab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Model4ShowCars> liste=new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        String showCarsData = "{\n" +
                "  \"Error\": 0,\n" +
                "  \"message\": \"[{\\\"model\\\":\\\"mercedes\\\",\\\"color\\\":\\\"green\\\",\\\"plates\\\":\\\"06 ag 2323\\\",\\\"seats\\\":3},{\\\"model\\\":\\\"bmv\\\",\\\"color\\\":\\\"black\\\",\\\"plates\\\":\\\"07 ag 2323\\\",\\\"seats\\\":4},{\\\"model\\\":\\\"porş\\\",\\\"color\\\":\\\"kirmizi\\\",\\\"plates\\\":\\\"09 ag 2323\\\",\\\"seats\\\":1},{\\\"model\\\":\\\"serce\\\",\\\"color\\\":\\\"mavi\\\",\\\"plates\\\":\\\"34 ag 2323\\\",\\\"seats\\\":7}]\"\n" +
                "}";

        try {
            parseJsonData(showCarsData);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ModelArrayAdapter modelArrayAdapter = new ModelArrayAdapter(getApplicationContext(),liste);
        listView.setAdapter(modelArrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, liste.get(position).getPlates(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void parseJsonData(String showCars) throws JSONException {
        JSONObject jsonObject = new JSONObject(showCars);
        int error = (int) jsonObject.get("Error");
        String carsArrStr = (String) jsonObject.get("message");
        JSONArray carsArr = new JSONArray(carsArrStr);

        Gson gson = new Gson();

        if(error == 0){
            for(int i = 0 ; i < carsArr.length() ; i++) {
                Model4ShowCars model4ShowCars = gson.fromJson(carsArr.get(i).toString(),Model4ShowCars.class);
                liste.add(model4ShowCars);
            }

        } else {
            Toast.makeText(this, "JSON Hatalıdır.", Toast.LENGTH_SHORT).show();
        }


    }
}
