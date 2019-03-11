package tr.ms.csgb.csgbtakvim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView goBack;
    ListView calendarListView;
    List<CalendarListModel> listOfCalendarListData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        goBack = (ImageView) findViewById(R.id.goBack);
        calendarListView = (ListView) findViewById(R.id.calendarListView);

        listOfCalendarListData = new ArrayList<>();
        listOfCalendarListData.add(new CalendarListModel("9\nAğustos",getResources().getColor(R.color.loginBtnUp),"Lorem ipsum dolor sit amet, consectetur adipiscing elit.","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam aliquam dolor tincidunt, interdum elit vel, vehicula mauris. Ut bibendum, justo nec efficitur bibendum, mi lacus porta felis, eget tincidunt orci magna semper elit."));
        listOfCalendarListData.add(new CalendarListModel("10\nAğustos",getResources().getColor(R.color.calendarItemColor1),"Lorem ipsum dolor sit amet, consectetur adipiscing elit.","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam aliquam dolor tincidunt, interdum elit vel, vehicula mauris. Ut bibendum, justo nec efficitur bibendum, mi lacus porta felis, eget tincidunt orci magna semper elit."));
        listOfCalendarListData.add(new CalendarListModel("4\nŞubat",getResources().getColor(R.color.calendarItemColor2),"Lorem ipsum dolor sit amet, consectetur adipiscing elit.","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam aliquam dolor tincidunt, interdum elit vel, vehicula mauris. Ut bibendum, justo nec efficitur bibendum, mi lacus porta felis, eget tincidunt orci magna semper elit."));
        listOfCalendarListData.add(new CalendarListModel("3\nŞubat",getResources().getColor(R.color.loginBtnUp),"Lorem ipsum dolor sit amet, consectetur adipiscing elit.","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam aliquam dolor tincidunt, interdum elit vel, vehicula mauris. Ut bibendum, justo nec efficitur bibendum, mi lacus porta felis, eget tincidunt orci magna semper elit."));
        listOfCalendarListData.add(new CalendarListModel("2\nŞubat",getResources().getColor(R.color.calendarItemColor1),"Lorem ipsum dolor sit amet, consectetur adipiscing elit.","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam aliquam dolor tincidunt, interdum elit vel, vehicula mauris. Ut bibendum, justo nec efficitur bibendum, mi lacus porta felis, eget tincidunt orci magna semper elit."));

        CalendarListViewAdapter calendarListViewAdapter = new CalendarListViewAdapter(this, listOfCalendarListData);
        calendarListView.setAdapter(calendarListViewAdapter);
    }

    public void goBack(View view){
        Toast.makeText(this, "Clicked Go Back", Toast.LENGTH_SHORT).show();
    }
}
