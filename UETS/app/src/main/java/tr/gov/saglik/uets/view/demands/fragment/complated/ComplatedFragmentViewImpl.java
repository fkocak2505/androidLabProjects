package tr.gov.saglik.uets.view.demands.fragment.complated;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.demands.dataModel.PendingApprovelAndComplatedModelData;
import tr.gov.saglik.uets.view.demands.adapter.PendingApprovelAndComplatedListViewAdapter;
import tr.gov.saglik.uets.view.demands.fragment.complated.IComplatedFragmentView;

public class ComplatedFragmentViewImpl extends Fragment implements IComplatedFragmentView {

    ListView complatedListView;
    List<PendingApprovelAndComplatedModelData> listOfComplatedData;


    public ComplatedFragmentViewImpl() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_complated, container, false);

        initPendingApprovelFragmentComponent(view);
        fillPendingApprovelListViewData();
        bindData2ListViewAdapter();

        return view;
    }

    @Override
    public void initPendingApprovelFragmentComponent(View view) {
        complatedListView = (ListView) view.findViewById(R.id.complatedListView);
    }

    @Override
    public void fillPendingApprovelListViewData() {
        listOfComplatedData = new ArrayList<>();
        listOfComplatedData.add(new PendingApprovelAndComplatedModelData("Ağustos 2019 13:35", R.drawable.demands_complated_status,getResources().getString(R.string.demandsCompleted),getResources().getColor(R.color.complatedTextColor), "Fatih Koçak", "Android Developer"));
        listOfComplatedData.add(new PendingApprovelAndComplatedModelData("Ağustos 2019 13:35", R.drawable.demands_complated_status,getResources().getString(R.string.demandsCompleted),getResources().getColor(R.color.complatedTextColor), "Fatih Koçak", "Android Developer"));
        listOfComplatedData.add(new PendingApprovelAndComplatedModelData("Ağustos 2019 13:35", R.drawable.demands_complated_status,getResources().getString(R.string.demandsCompleted),getResources().getColor(R.color.complatedTextColor), "Fatih Koçak", "Android Developer"));
        listOfComplatedData.add(new PendingApprovelAndComplatedModelData("Ağustos 2019 13:35", R.drawable.demands_complated_status,getResources().getString(R.string.demandsCompleted),getResources().getColor(R.color.complatedTextColor), "Fatih Koçak", "Android Developer"));

        bindData2ListViewAdapter();

    }

    @Override
    public void bindData2ListViewAdapter() {
        PendingApprovelAndComplatedListViewAdapter pendingApprovelAndComplatedListViewAdapter = new PendingApprovelAndComplatedListViewAdapter(getActivity().getApplicationContext(), listOfComplatedData);
        complatedListView.setAdapter(pendingApprovelAndComplatedListViewAdapter);
    }
}