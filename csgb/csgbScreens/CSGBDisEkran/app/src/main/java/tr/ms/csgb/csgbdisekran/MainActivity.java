package tr.ms.csgb.csgbdisekran;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide(); // hide actionBar

        setContentView(R.layout.activity_main);

        /// Real Time Permission
        requestStoragePermission();

        GridView grid;
        final String[] web = {"Belge Doğrulama","Haberler","Duyurular","Ne Yapmalıyım?","Nasıl Yaparım","Kendini Değerlendir"};
        int[] imageId = {
                R.drawable.belge_dogrulama,
                R.drawable.haberler,
                R.drawable.duyuru,
                R.drawable.ne_yapmaliyim,
                R.drawable.nasil_yaparim,
                R.drawable.kendini_degerlendir
        };

        CustomGrid adapter = new CustomGrid(MainActivity.this, web, imageId);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, web[position], Toast.LENGTH_SHORT).show();
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
                Toast.makeText(this, "Permission granted now you can call the phone", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }
}
