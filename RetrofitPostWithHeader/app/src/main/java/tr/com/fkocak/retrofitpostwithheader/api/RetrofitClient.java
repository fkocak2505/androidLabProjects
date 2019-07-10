package tr.com.fkocak.retrofitpostwithheader.api;

import retrofit2.Retrofit;
import tr.com.fkocak.retrofitpostwithheader.api.convertor.CustomRetrofitConverterFactory;

/**
 * Created by fatihkocak on 25.04.2019.
 */

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(CustomRetrofitConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
