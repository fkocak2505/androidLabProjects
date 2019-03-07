package tr.gov.saglik.uets.model.login;

import tr.gov.saglik.uets.RequestResultListener;

public interface ILoginActivityModel {

    void doLogin(String userName, String password, RequestResultListener requestResultListener);

}
