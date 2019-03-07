package tr.gov.saglik.uets.presenter.login;

import tr.gov.saglik.uets.RequestResultListener;
import tr.gov.saglik.uets.model.login.ILoginActivityModel;
import tr.gov.saglik.uets.view.login.ILoginActivityView;

public class LoginActivityPresenterImpl implements ILoginActivityPresenter {

    private ILoginActivityModel iLoginActivityModel;
    private ILoginActivityView iLoginActivityView;

    public LoginActivityPresenterImpl(ILoginActivityModel iLoginActivityModel, ILoginActivityView iLoginActivityView) {
        this.iLoginActivityModel = iLoginActivityModel;
        this.iLoginActivityView = iLoginActivityView;
    }


    @Override
    public void doLogin(String userName, String password) {
        iLoginActivityView.showLoading();
        iLoginActivityModel.doLogin(userName, password, new RequestResultListener() {
            @Override
            public void onSuccess() {
                iLoginActivityView.hideLoading();
                iLoginActivityView.goDemandsActivity();
            }

            @Override
            public void onFail() {
                iLoginActivityView.errorLogin("Kullanıcı adınız hatalıdır.");
            }
        });
    }
}
