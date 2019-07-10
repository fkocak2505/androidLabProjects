package tr.com.fkocak.retrofitpostwithheader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tr.com.fkocak.retrofitpostwithheader.api.ApiUtils;
import tr.com.fkocak.retrofitpostwithheader.api.interfaced.APIService;
import tr.com.fkocak.retrofitpostwithheader.model.ResponseData;
import tr.com.fkocak.retrofitpostwithheader.modelOfData.ResponseLoginData;
import tr.com.fkocak.retrofitpostwithheader.modelOfRequest.FilterList;
import tr.com.fkocak.retrofitpostwithheader.modelOfRequest.LoginParam;
import tr.com.fkocak.retrofitpostwithheader.modelOfRequest.NewsParam;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button deneme;

    private APIService apiService;
    LoginParam loginParam;
    Gson gson = new Gson();

    NewsParam newsParam = new NewsParam();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = ApiUtils.getAPIService();
        login = (Button) findViewById(R.id.login);
        deneme = (Button) findViewById(R.id.deneme);

        List<FilterList> filterListList = new ArrayList<>();
        filterListList.add(new FilterList("dataTpId","750"));


        newsParam.setPage(0);
        newsParam.setSize(1);
        newsParam.setFilterList(filterListList);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginParam = new LoginParam();
                loginParam.setPassword("admin");
                loginParam.setRememberMe(1);
                loginParam.setUsername("katip_admin");
                sendRequestWithPojo(loginParam);
            }
        });

        deneme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsParam.setPage(newsParam.getPage() + 1);
                sendRequestWithHeaderKey("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJrYXRpcF9hZG1pbiIsImNyZWF0ZWQiOjE1NTYyNjYyNjMwOTMsImlkIjowLCJleHAiOjE1NjQwNDIyNjN9.z_Ru-8Tq33AKqfnu7OQzE5m0kdk_SqMpq5nNWX87gmeTe5FkhfgO4yS6SupL0e-NZjHWzFSZxoSyNVlhkYxNvg");
            }
        });
    }

    public void sendRequestWithPojo(LoginParam loginParam){
        apiService.savePostWithPojoModel(RequestBody.create(MediaType.parse("application/json"),gson.toJson(loginParam))).enqueue(new Callback<ResponseLoginData>() {
            @Override
            public void onResponse(Call<ResponseLoginData> call, Response<ResponseLoginData> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, response.headers().get("Authorization"), Toast.LENGTH_SHORT).show();
                    sendRequestWithHeaderKey(response.headers().get("Authorization"));
                } else {
                    Toast.makeText(MainActivity.this, "Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLoginData> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Unable to submit post to API.", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void sendRequestWithHeaderKey(String key){
        apiService.getDataWithHeaderKey(key,RequestBody.create(MediaType.parse("application/json"),gson.toJson(newsParam))).enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                int a = 5;
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                int a = 5;
            }
        });
    }
}
