package com.example.fkocak.notificationmanager;

import retrofit2.Call;
import retrofit2.Callback;

public class RetrofitCallInvoker {
    private ICommandCallService commandCallService;

    public void setCommandCallService(ICommandCallService commandCallService){
        this.commandCallService = commandCallService;
    }



    public <T> void callServiceAsync(Call<T> tCall, Callback<T> callback){
        commandCallService.callAsync(tCall,callback);
    }
}

