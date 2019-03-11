package tr.ms.csgb.deneme.fragment;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tr.ms.csgb.deneme.R;
import tr.ms.csgb.deneme.adapter.MessagesListViewAdapter;
import tr.ms.csgb.deneme.data_model.MessagesListDataModel;


public class ThreeFragment extends Fragment{

    ConstraintLayout noMessagesLayout;
    ConstraintLayout messagesLayout;
    ListView messagesListView;
    List<MessagesListDataModel> listOfMessagesData;

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "click Fab", Toast.LENGTH_SHORT).show();
            }
        });

        noMessagesLayout = (ConstraintLayout) view.findViewById(R.id.noMessagesLayout);
        messagesLayout = (ConstraintLayout) view.findViewById(R.id.messagesLayout);
        messagesListView = (ListView) view.findViewById(R.id.messagesListView);


        MessagesListViewAdapter messagesListViewAdapter = new MessagesListViewAdapter(getActivity().getApplicationContext(),fillListViewData());
        messagesListView.setAdapter(messagesListViewAdapter);

        List<Boolean> deletedAfter = new ArrayList<>();
        deletedAfter.add(true);
        deletedAfter.add(false);

        int index = new Random().nextInt(2);
        boolean val = deletedAfter.get(index);
        if(val){
            noMessagesLayout.setVisibility(View.VISIBLE);
            messagesLayout.setVisibility(View.GONE);
        } else {
            noMessagesLayout.setVisibility(View.GONE);
            messagesLayout.setVisibility(View.VISIBLE);
        }

        return view;
    }

    public List<MessagesListDataModel> fillListViewData(){
        listOfMessagesData = new ArrayList<>();
        listOfMessagesData.add(new MessagesListDataModel(R.drawable.message_tab_new_message,R.mipmap.ic_launcher_round,"Fatih Koçak","Sözleşmeler hakkında mailini bekliyoruz. Lorem İpsum Lorem İpsum Lorem İpsum Lorem İpsum",true));
        listOfMessagesData.add(new MessagesListDataModel(R.drawable.message_tab_new_message,R.mipmap.ic_launcher_round,"Fatih Koçak","Sözleşmeler hakkında mailini bekliyoruz. Lorem İpsum Lorem İpsum Lorem İpsum Lorem İpsum",true));
        listOfMessagesData.add(new MessagesListDataModel(R.drawable.message_tab_new_message,R.mipmap.ic_launcher_round,"Fatih Koçak","Sözleşmeler hakkında mailini bekliyoruz. Lorem İpsum Lorem İpsum Lorem İpsum Lorem İpsum",false));
        listOfMessagesData.add(new MessagesListDataModel(R.drawable.message_tab_new_message,R.mipmap.ic_launcher_round,"Fatih Koçak","Sözleşmeler hakkında mailini bekliyoruz. Lorem İpsum Lorem İpsum Lorem İpsum Lorem İpsum",false));
        listOfMessagesData.add(new MessagesListDataModel(R.drawable.message_tab_new_message,R.mipmap.ic_launcher_round,"Fatih Koçak","Sözleşmeler hakkında mailini bekliyoruz. Lorem İpsum Lorem İpsum Lorem İpsum Lorem İpsum",true));
        listOfMessagesData.add(new MessagesListDataModel(R.drawable.message_tab_new_message,R.mipmap.ic_launcher_round,"Fatih Koçak","Sözleşmeler hakkında mailini bekliyoruz. Lorem İpsum Lorem İpsum Lorem İpsum Lorem İpsum",true));
        listOfMessagesData.add(new MessagesListDataModel(R.drawable.message_tab_new_message,R.mipmap.ic_launcher_round,"Fatih Koçak","Sözleşmeler hakkında mailini bekliyoruz. Lorem İpsum Lorem İpsum Lorem İpsum Lorem İpsum",true));
        listOfMessagesData.add(new MessagesListDataModel(R.drawable.message_tab_new_message,R.mipmap.ic_launcher_round,"Fatih Koçak","Sözleşmeler hakkında mailini bekliyoruz. Lorem İpsum Lorem İpsum Lorem İpsum Lorem İpsum",true));
        listOfMessagesData.add(new MessagesListDataModel(R.drawable.message_tab_new_message,R.mipmap.ic_launcher_round,"Fatih Koçak","Sözleşmeler hakkında mailini bekliyoruz. Lorem İpsum Lorem İpsum Lorem İpsum Lorem İpsum",true));
        return listOfMessagesData;
    }

}