package tr.gov.saglik.uets.model.welcome;

import tr.gov.saglik.uets.RequestResultListener;

public class WelcomeActivityModelImpl implements IWelcomeActivityModel {
    @Override
    public void getSelectedData(String menuTitle, RequestResultListener requestResultListener) {
        requestResultListener.onSuccess(); /// Retrofit
    }

}
