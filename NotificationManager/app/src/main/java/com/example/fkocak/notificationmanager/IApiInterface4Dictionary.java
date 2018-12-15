package com.example.fkocak.notificationmanager;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IApiInterface4Dictionary {

    @GET("search")
    Call<String> getHangmanWord(@Query("query") String query);
}
