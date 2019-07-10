package tr.com.fkocak.retrofitpostwithheader.api.interfaced;

/**
 * Created by fatihkocak on 25.04.2019.
 */

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import tr.com.fkocak.retrofitpostwithheader.model.ResponseData;
import tr.com.fkocak.retrofitpostwithheader.modelOfData.ResponseLoginData;


public interface APIService {

    @POST("/isg-katip/auth")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<ResponseLoginData> savePostWithPojoModel(@Body RequestBody type);

    @POST("/isg-katip/v1/cntnt/search")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<ResponseData> getDataWithHeaderKey(@Header("Remember") String auth, @Body RequestBody type);

}
