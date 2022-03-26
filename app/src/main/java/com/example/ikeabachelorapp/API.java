package com.example.ikeabachelorapp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface API {
    @Headers({"Accept: application/json"})
    @GET("/")
    Call<String> getTest();
}
