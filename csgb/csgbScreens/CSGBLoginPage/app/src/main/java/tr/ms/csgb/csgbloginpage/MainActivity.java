package tr.ms.csgb.csgbloginpage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import studio.carbonylgroup.textfieldboxes.TextFieldBoxes;

public class MainActivity extends AppCompatActivity {

    EditText edtTCKimlikNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide(); // hide actionBar

        /// Real Time Permission
        requestStoragePermission();

        edtTCKimlikNo = (EditText) findViewById(R.id.edtTCKimlikNo);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtTCKimlikNo.setBackground(getResources().getDrawable(R.drawable.edt_error_input));
                edtTCKimlikNo.setHint("TC' de hata var");
            }
        });
    }

    public void callNumber(View view){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:170"));
        startActivity(intent);
    }

    //Requesting permission
    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
            //Kullanıcı izin verdiyse daha önce buraya düşer
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
            /// Kullanıcı izni reddederse buraya düşer..
            int a = 5;
        }

        /// İlk defa izin isteniyorsa buraya düşer
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Telefonla aramak için izin verildi", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Telefonla aramak için gerekli izin verilmedi..!", Toast.LENGTH_LONG).show();
            }
        }
    }

}
