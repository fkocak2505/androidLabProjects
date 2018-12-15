package tr.org.tobb.findmostcommon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FileReader file = null;
        BufferedReader br = null;
        String st;
        try {
            file = new FileReader("/Users/fatihkocak/Desktop/textFolder/text.txt");
            br = new BufferedReader(file);
            while ((st = br.readLine()) != null)
                Toast.makeText(this, st, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
