package tr.gov.saglik.uets.view.login;

import android.view.View;

public interface ILoginActivityView {

    void initLoginActivityComponent();
    void doLogin(View view);
    void showLoading();
    void hideLoading();
    void errorLogin(String message);
    void goDemandsActivity();
}
