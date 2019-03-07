package tr.gov.saglik.uets.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tr.gov.saglik.uets.view.demands.DemandsActivityViewImpl;
import tr.gov.saglik.uets.R;
import tr.gov.saglik.uets.model.login.LoginActivityModelImpl;
import tr.gov.saglik.uets.presenter.login.LoginActivityPresenterImpl;

public class LoginActivityViewImpl extends AppCompatActivity implements ILoginActivityView {

    Button loginBtn;
    EditText userName;
    EditText password;

    String strOfUserName = "";
    String strOfPassword = "";

    LoginActivityPresenterImpl loginActivityPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        initLoginActivityComponent();

    }


    @Override
    public void initLoginActivityComponent() {
        loginBtn = (Button) findViewById(R.id.btnLogin);
        userName = (EditText) findViewById(R.id.edtUserName);
        password = (EditText) findViewById(R.id.edtPassword);

        loginActivityPresenter = new LoginActivityPresenterImpl(new LoginActivityModelImpl(), this);
    }

    @Override
    public void doLogin(View view) {
        if (isUserLoginInfoValid())
            loginActivityPresenter.doLogin(strOfUserName, strOfPassword);
        else
            Toast.makeText(this, "Kullanıcı adı ya da şifre boş girilemez..!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "Progress Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(this, "Progress Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorLogin(String messages) {
        userName.setText("");
        userName.setBackground(getResources().getDrawable(R.drawable.login_input_error));
        userName.setHint(messages);
    }

    @Override
    public void goDemandsActivity() {
        startActivity(new Intent(getApplicationContext(), DemandsActivityViewImpl.class));
    }

    public boolean isUserLoginInfoValid() {
        if (userName.getText().toString().equals(""))
            return false;
        if (password.getText().toString().equals(""))
            return false;
        strOfUserName = userName.getText().toString();
        strOfPassword = password.getText().toString();
        return true;
    }
}
