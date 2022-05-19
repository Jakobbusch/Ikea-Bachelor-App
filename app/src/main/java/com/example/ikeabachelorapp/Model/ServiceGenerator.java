package com.example.ikeabachelorapp.Model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ServiceGenerator {

    private static API Api;

    public static API getApi() {


        if (Api == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Api = new Retrofit.Builder()
                    .baseUrl("https://batchelor-project-ikea.herokuapp.com")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(API.class);
        }
        return Api;
    }
}
