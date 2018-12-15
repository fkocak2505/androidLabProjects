package tr.com.cs.popupspinnerexample;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] DayOfWeek = {"KUMPET PETROL ÜRÜNLERİ TURİZM GIDA OTOMOTİV NAKLİYAT TİCARET VE SANAYİ LTD.ŞTİ.", "ABİS MAKİNA İNŞAAT VE DIŞ TİCARET SANAYİ ANONİM ŞİRKETİ"};
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnOpenPopup = (Button) findViewById(R.id.button);
        constraintLayout = (ConstraintLayout) findViewById(R.id.deneme);

        btnOpenPopup.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showDialog4FirmaSecimi(arg0);
            }

        });
    }

    public void showDialog4FirmaSecimi(View view){
        constraintLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        LayoutInflater layoutInflater =
                (LayoutInflater) getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.custom, null);
        final PopupWindow popupWindow = new PopupWindow(
                popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);

        final Spinner popupSpinner = (Spinner) popupView.findViewById(R.id.popupspinner);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item, DayOfWeek);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        popupSpinner.setAdapter(adapter);

        btnDismiss.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                constraintLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                popupWindow.dismiss();
                Toast.makeText(MainActivity.this, popupSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
        });

//        popupWindow.showAsDropDown(btnOpenPopup, 50, -30);
    }
}
