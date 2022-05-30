package com.example.ikeabachelorapp.Model;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface API {
    /**
     * API interface call
     * @apiNote productList
     */
    @Headers({"Accept: application/json"})
    @GET("/products")
    Call <List<ResponseProduct>> productList();
}
