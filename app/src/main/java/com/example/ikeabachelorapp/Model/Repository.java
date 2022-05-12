package com.example.ikeabachelorapp.Model;
import android.util.Log;

import com.example.ikeabachelorapp.API;

import java.util.List;

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


    public void getProductList(){
        API api = ServiceGenerator.getApi();
        Call<List<ResponseProduct>> call = api.productList();
        call.enqueue(new Callback<List<ResponseProduct>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<ResponseProduct>> call, Response<List<ResponseProduct>> response) {

                if (response.isSuccessful()){
                    if (response.body() != null){

                        for (int i = 0; i < response.body().size(); i++) {
                            System.out.println(response.body().get(i).productID + " " + response.body().get(i).productName + " " + response.body().get(i).productType + " " + response.body().get(i).productPrice);
                        }
                    }else{
                        Log.i("onEmptyResponse", "Returned empty response");
                    }

                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<ResponseProduct>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
                Log.i("Error",t.getMessage());
                Log.d("responseMsg",t.toString());
            }
        });
    }
}
