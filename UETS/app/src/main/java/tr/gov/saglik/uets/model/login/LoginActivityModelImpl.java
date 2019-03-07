package tr.gov.saglik.uets.model.login;

import tr.gov.saglik.uets.RequestResultListener;

public class LoginActivityModelImpl implements ILoginActivityModel {
    @Override
    public void doLogin(String userName, String password, RequestResultListener requestResultListener) {
        requestResultListener.onSuccess(); //// Retrofit
    }
}
