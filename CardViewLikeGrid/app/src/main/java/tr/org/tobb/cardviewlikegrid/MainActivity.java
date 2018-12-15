package tr.org.tobb.cardviewlikegrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CustomAdapter adapter;
    GridView gv;
    ArrayList<Spacecraft> spacecrafts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv= (GridView) findViewById(R.id.gv);

        adapter=new CustomAdapter(this,getData());
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, spacecrafts.get(i).getName() , Toast.LENGTH_SHORT).show();
            }
        });

    }
    private ArrayList getData()
    {
        spacecrafts=new ArrayList<>();

        Spacecraft s=new Spacecraft();
        s.setName("Pioneer");
        s.setPropellant("Chemical Energy");
        s.setImage(R.drawable.ic_launcher);
        spacecrafts.add(s);

        s=new Spacecraft();
        s.setName("Spitzer");
        s.setPropellant("Warp Drive");
        s.setImage(R.drawable.ic_launcher);
        spacecrafts.add(s);

        s=new Spacecraft();
        s.setName("Enterprise");
        s.setPropellant("Anti Matter");
        s.setImage(R.drawable.user);
        spacecrafts.add(s);

        s=new Spacecraft();
        s.setName("Hubble");
        s.setPropellant("Laser Beam");
        s.setImage(R.drawable.ic_launcher);
        spacecrafts.add(s);

        s=new Spacecraft();
        s.setName("Voyager");
        s.setPropellant("Solar Energy");
        s.setImage(R.drawable.ic_launcher);
        spacecrafts.add(s);

        return spacecrafts;
    }
}
