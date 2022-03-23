package com.example.ikeabachelorapp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    @GET("/")
    Call<Response> getTest();
}
