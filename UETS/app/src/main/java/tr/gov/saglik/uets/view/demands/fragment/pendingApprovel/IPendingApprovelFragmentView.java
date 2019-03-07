package tr.gov.saglik.uets.view.demands.fragment.pendingApprovel;

import android.view.View;

public interface IPendingApprovelFragmentView {

    void initPendingApprovelFragmentComponent(View view);
    void fillPendingApprovelListViewData();
    void bindData2ListViewAdapter();
    void clickPendingApprovalItem();

}
