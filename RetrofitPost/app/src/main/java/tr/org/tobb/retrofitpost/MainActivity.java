package tr.org.tobb.retrofitpost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tr.org.tobb.retrofitpost.api.ApiUtils;
import tr.org.tobb.retrofitpost.api.interfaced.APIService;
import tr.org.tobb.retrofitpost.modelOfData.Response4ActionCards;
import tr.org.tobb.retrofitpost.modelOfRequest.TypeOfDoc;

public class MainActivity extends AppCompatActivity {

    Button bntnOfSendRequestWithPojo;
    Button bntnOfSendRequestWithString;
    String type = "cce";
    private APIService apiService;
    TypeOfDoc typeOfDoc;
    RequestBody paramOfRequest;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = ApiUtils.getAPIService();

        bntnOfSendRequestWithPojo = (Button) findViewById(R.id.sendRequestWithPojo);
        bntnOfSendRequestWithString = (Button) findViewById(R.id.sendRequestWithStr);

        bntnOfSendRequestWithPojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typeOfDoc = new TypeOfDoc();
                typeOfDoc.setType(type);
                sendRequestWithPojo(typeOfDoc);
            }
        });

        bntnOfSendRequestWithString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typeOfDoc = new TypeOfDoc();
                typeOfDoc.setType(type);
                sendRequestWithString(typeOfDoc);
            }
        });
    }

    public void sendRequestWithPojo(TypeOfDoc typeOfDoc){
        apiService.savePostWithPojoModel(RequestBody.create(MediaType.parse("application/json"),gson.toJson(typeOfDoc))).enqueue(new Callback<Response4ActionCards>() {
            @Override
            public void onResponse(Call<Response4ActionCards> call, Response<Response4ActionCards> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response4ActionCards> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Unable to submit post to API.", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void sendRequestWithString(TypeOfDoc typeOfDoc){
        apiService.savePostWithString(RequestBody.create(MediaType.parse("application/json"),gson.toJson(typeOfDoc))).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Unable to submit post to API.", Toast.LENGTH_LONG).show();
            }
        });
    }




}
