package tr.gov.saglik.uets.view.demands.fragment.pendingApprovel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.demands.dataModel.PendingApprovelAndComplatedModelData;
import tr.gov.saglik.uets.view.demands.adapter.PendingApprovelAndComplatedListViewAdapter;
import tr.gov.saglik.uets.view.demandsDetail.DemandsDetailActivityViewImpl;

public class PendingApprovelFragmentViewImpl extends Fragment implements IPendingApprovelFragmentView {

    ListView pendingApprovelListView;
    List<PendingApprovelAndComplatedModelData> listOfPendingApprovelData;


    public PendingApprovelFragmentViewImpl() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pending_approvel, container, false);

        initPendingApprovelFragmentComponent(view);
        fillPendingApprovelListViewData();
        bindData2ListViewAdapter();
        clickPendingApprovalItem();

        return view;
    }

    @Override
    public void initPendingApprovelFragmentComponent(View view) {
        pendingApprovelListView = (ListView) view.findViewById(R.id.pendingApprovelListView);
    }

    @Override
    public void fillPendingApprovelListViewData() {
        listOfPendingApprovelData = new ArrayList<>();
        listOfPendingApprovelData.add(new PendingApprovelAndComplatedModelData("Ağustos 2019 13:35", R.drawable.demands_pending_approvel_status,getResources().getString(R.string.demandsPendingApprovelText),getResources().getColor(R.color.pendingApprovelTextColor), "Fatih Koçak", "Android Developer"));
        listOfPendingApprovelData.add(new PendingApprovelAndComplatedModelData("Ağustos 2019 13:35", R.drawable.demands_pending_approvel_status,getResources().getString(R.string.demandsPendingApprovelText),getResources().getColor(R.color.pendingApprovelTextColor), "Fatih Koçak", "Android Developer"));
        listOfPendingApprovelData.add(new PendingApprovelAndComplatedModelData("Ağustos 2019 13:35", R.drawable.demands_pending_approvel_status,getResources().getString(R.string.demandsPendingApprovelText),getResources().getColor(R.color.pendingApprovelTextColor), "Fatih Koçak", "Android Developer"));
        listOfPendingApprovelData.add(new PendingApprovelAndComplatedModelData("Ağustos 2019 13:35", R.drawable.demands_pending_approvel_status,getResources().getString(R.string.demandsPendingApprovelText),getResources().getColor(R.color.pendingApprovelTextColor), "Fatih Koçak", "Android Developer"));

        bindData2ListViewAdapter();

    }

    @Override
    public void bindData2ListViewAdapter() {
        PendingApprovelAndComplatedListViewAdapter pendingApprovelAndComplatedListViewAdapter = new PendingApprovelAndComplatedListViewAdapter(getActivity().getApplicationContext(), listOfPendingApprovelData);
        pendingApprovelListView.setAdapter(pendingApprovelAndComplatedListViewAdapter);
    }

    @Override
    public void clickPendingApprovalItem() {
        pendingApprovelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity().getApplicationContext(), DemandsDetailActivityViewImpl.class));
            }
        });
    }
}
