package tr.gov.saglik.uets.view.demandsDetail.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tr.gov.saglik.uets.R;

public class DemandItemInfoFragmentViewImpl extends Fragment implements IDemandItemInfoFragmentView {

    public DemandItemInfoFragmentViewImpl() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_demands_detail_demands_info,container,false);


        return view;
    }
}
