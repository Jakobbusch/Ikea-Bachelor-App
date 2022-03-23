package com.example.ikeabachelorapp;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ServiceGenerator {

    private static API Api;

    public static API getApi() {
        if (Api == null) {
            Api = new Retrofit.Builder()
                    .baseUrl("https://batchelor-project-ikea.herokuapp.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(API.class);
        }
        return Api;
    }
}
