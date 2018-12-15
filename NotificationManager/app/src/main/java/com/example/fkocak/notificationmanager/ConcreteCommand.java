package com.example.fkocak.notificationmanager;

import retrofit2.Call;
import retrofit2.Callback;

public class ConcreteCommand implements ICommandCallService {
    RetrofitCallReceiver retrofitCallReceiver;

    public ConcreteCommand(RetrofitCallReceiver retrofitCallReceiver){
        this.retrofitCallReceiver = retrofitCallReceiver;
    }

    @Override
    public <T> void callAsync(Call<T> tCall, Callback<T> callback) {
        retrofitCallReceiver.callServiceAsync(tCall,callback);
    }
}
