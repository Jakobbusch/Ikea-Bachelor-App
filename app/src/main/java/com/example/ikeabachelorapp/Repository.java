package com.example.ikeabachelorapp;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;


public class Repository {
    private static Repository instance;




    public static synchronized Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }


    public void getTest(){
        API api = ServiceGenerator.getApi();
        Call<String> call = api.getTest();
        call.enqueue(new Callback<String>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.i("onSuccess", response.body().toString());
                        System.out.println(response.body().toString());
                    }else{
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }

                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
                Log.i("Error",t.getMessage());
                Log.d("responseMsg",t.toString());
            }
        });
    }
}
