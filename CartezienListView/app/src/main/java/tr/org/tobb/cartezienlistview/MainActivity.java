package tr.org.tobb.cartezienlistview;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ModelOfCars> modelOfCarsList = new ArrayList<>();
    List<String> hat = new ArrayList<>();

    List<ModelOfCars> modelOfCarsListWithHat = new ArrayList<>();

    ListView listView;
    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        modelOfCarsList.add(new ModelOfCars("mercedes","06 E 9690","siyah",4,""));
        modelOfCarsList.add(new ModelOfCars("porsche","06 E 9691","yesil",3,""));
        modelOfCarsList.add(new ModelOfCars("renault","06 E 9692","mavi",5,""));
        modelOfCarsList.add(new ModelOfCars("citroen","06 E 9693","kirmizi",2,""));

        hat.add("Bilkent-Kızılay");
        hat.add("Etimesgut-Sincan");
        hat.add("batıkent-Bilkent");

        cartezianOfModelCarsAndHat();

        listView.setAdapter(new ListViewAdapter(getApplicationContext(),modelOfCarsListWithHat));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                showAlertDialogExit(modelOfCarsListWithHat.get(position).getKoltukSayisi());
            }
        });
    }


    public void cartezianOfModelCarsAndHat(){
        for(int i = 0 ; i < hat.size(); i++){
            for(ModelOfCars modelOfCarsItem : modelOfCarsList){
                modelOfCarsListWithHat.add(new ModelOfCars(
                        modelOfCarsItem.getModel(),
                        modelOfCarsItem.getPlaka(),
                        modelOfCarsItem.getRenk(),
                        modelOfCarsItem.getKoltukSayisi(),
                        hat.get(i)
                        ));
            }
        }
    }

    protected void showAlertDialogExit(int numberOfSeat) {
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.decide_seat_number, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptView);

        Button startTrip = (Button) promptView.findViewById(R.id.start);
        EditText seatNumber = (EditText) promptView.findViewById(R.id.seatNumber);
            seatNumber.setText(String.valueOf(numberOfSeat));

        alert = alertDialogBuilder.create();

        try {
            alert.show();
        } catch (Exception e) {

        }

        startTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /// START TRİP Butonuna basılınca olacak olanlar burada yazılacak....
                alert.cancel();

            }
        });
    }
}
