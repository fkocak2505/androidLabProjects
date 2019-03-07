package tr.gov.saglik.uets.view.profil.demandsRecommendations;

import android.view.View;

public interface IDemandsAndRecommendationsActivityView {

    void initWelcomeActivityComponent();
    void fillDemandsRecommendationListViewData();
    void bindDemandsRecommendationData2Adapter();
    void clickAddDemandsRecommendation();
}
