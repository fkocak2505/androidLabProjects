package com.example.fkocak.notificationmanager;

import retrofit2.Call;
import retrofit2.Callback;

public interface ICommandCallService {
    public <T> void callAsync(Call<T> tCall, Callback<T> callback);
}

