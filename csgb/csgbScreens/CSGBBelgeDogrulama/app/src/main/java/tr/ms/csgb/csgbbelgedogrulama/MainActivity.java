package tr.ms.csgb.csgbbelgedogrulama;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

    }


    public void goBack(View view) {
        Toast.makeText(this, "Tapped Back", Toast.LENGTH_SHORT).show();
    }

    public void showInfo(View view) {
        List<DocVerifyInfoDialogModel> listOfDocVerifyData = new ArrayList<>();
        listOfDocVerifyData.add(new DocVerifyInfoDialogModel("Barkod İle Doğrulama Nasıl Gerçekleştirilir?", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));
        listOfDocVerifyData.add(new DocVerifyInfoDialogModel("Belge No İle Doğrulama Nasıl Gerçekleştirilir?", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View convertView = (View) inflater.inflate(R.layout.belge_dogrulama_alert_dialog_info, null);
        alertDialog.setView(convertView);

        final AlertDialog dialog = alertDialog.create();

        ListView lv = (ListView) convertView.findViewById(R.id.listView1);
        DocVerifyInfoListAdapter docVerifyInfoListAdapter = new DocVerifyInfoListAdapter(this, listOfDocVerifyData);
        lv.setAdapter(docVerifyInfoListAdapter);

        TextView closeInfoDailog = (TextView) convertView.findViewById(R.id.closeDocVerifyInfoDialog);
        closeInfoDailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    public void clickBarkodDogrulama(View view) {
        Toast.makeText(this, "clickBarkodDogrulama", Toast.LENGTH_SHORT).show();
    }

    public void docVerfy(View view) {
        Toast.makeText(this, "Doğrulandı", Toast.LENGTH_SHORT).show();
    }
}
