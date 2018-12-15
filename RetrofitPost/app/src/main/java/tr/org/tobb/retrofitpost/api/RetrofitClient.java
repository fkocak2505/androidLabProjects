package tr.org.tobb.retrofitpost.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tr.org.tobb.retrofitpost.api.converter.CustomRetrofitConverterFactory;

/**
 * Created by fatihkocak on 1.09.2018.
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


