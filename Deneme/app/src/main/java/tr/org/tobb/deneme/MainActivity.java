package tr.org.tobb.deneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText password;
    Button signIn;

    Switch switchBtn;

    String realUserName4Surucu = "umur.fatih";
    String realPassword4Surucu = "123";

    String realUserName4Otostop = "fatih.umur.gokhan";
    String realPassword4Otostop = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        signIn = (Button) findViewById(R.id.signIn);
        switchBtn = (Switch) findViewById(R.id.switch1);


        switchBtn.setChecked(false);
        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                if (isCheck) {
                    Toast.makeText(MainActivity.this, "Açık", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Kapalı", Toast.LENGTH_SHORT).show();
                }

            }
        });


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = userName.getText().toString();
                String strPassword = password.getText().toString();

                if (switchBtn.isChecked()) {
                    if (strUserName.equals(realUserName4Surucu) && strPassword.equals(realPassword4Surucu)) {
                        startActivity(new Intent(getApplicationContext(), Dashboard.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Giriş Bilgileri yanlıştır", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (strUserName.equals(realUserName4Otostop) && strPassword.equals(realPassword4Otostop)) {
                        startActivity(new Intent(getApplicationContext(), OtostopEkrani.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Giriş Bilgileri yanlıştır", Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });

    }
}
