package tr.org.tobb.retrofitpost.api.interfaced;

/**
 * Created by fatihkocak on 1.09.2018.
 */
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import tr.org.tobb.retrofitpost.modelOfData.Response4ActionCards;
import tr.org.tobb.retrofitpost.modelOfRequest.TypeOfDoc;

public interface APIService {

    @POST("/api/actionsCards")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<String> savePostWithString(@Body RequestBody type);

    @POST("/api/actionsCards")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<Response4ActionCards> savePostWithPojoModel(@Body RequestBody type);

}
