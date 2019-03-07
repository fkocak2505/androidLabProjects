package tr.gov.saglik.uets.view.profil.userInfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import tr.gov.saglik.uets.R;

public class UserInfoActivityViewImpl extends AppCompatActivity implements IUserInfoActivityView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_user_info);

        getSupportActionBar().hide();
    }
}
