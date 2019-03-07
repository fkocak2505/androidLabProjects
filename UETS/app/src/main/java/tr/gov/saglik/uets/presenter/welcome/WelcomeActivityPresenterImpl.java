package tr.gov.saglik.uets.presenter.welcome;

import tr.gov.saglik.uets.RequestResultListener;
import tr.gov.saglik.uets.model.welcome.IWelcomeActivityModel;
import tr.gov.saglik.uets.view.welcome.IWelcomeActivityView;

public class WelcomeActivityPresenterImpl implements IWelcomeActivityPresenter {
    private IWelcomeActivityModel iWelcomeActivityModel;
    private IWelcomeActivityView iWelcomeActivityView;

    public WelcomeActivityPresenterImpl(IWelcomeActivityModel iWelcomeActivityModel, IWelcomeActivityView iWelcomeActivityView) {
        this.iWelcomeActivityModel = iWelcomeActivityModel;
        this.iWelcomeActivityView = iWelcomeActivityView;
    }

    @Override
    public void getSelectedData(final String menuTitle) {
        iWelcomeActivityView.showLoading();
        iWelcomeActivityModel.getSelectedData(menuTitle, new RequestResultListener() {
            @Override
            public void onSuccess() {
                iWelcomeActivityView.hideLoading(menuTitle);
            }

            @Override
            public void onFail() {

            }
        });
    }
}
