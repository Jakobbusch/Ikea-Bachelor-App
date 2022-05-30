package com.example.ikeabachelorapp.Model;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;


public class Repository {
    private static Repository instance;
    private MutableLiveData<List<Product>> productList;
    private Product selectedProduct;

    /**
     * Constructor Repository
     */
    private Repository(){
        productList = new MutableLiveData<>();
    }

    /**
     * Get instance
     * @return instance
     */
    public static synchronized Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    /**
     * Get products
     * @return productList
     */
    public synchronized LiveData<List<Product>> getProducts(){
        return productList;
    }

    /**
     * Get list of product
     * Create API call
     */
    public void getProductList(){
        API api = ServiceGenerator.getApi();
        Call<List<ResponseProduct>> call = api.productList();
        call.enqueue(new Callback<List<ResponseProduct>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<ResponseProduct>> call, Response<List<ResponseProduct>> response) {

                System.out.println(response.body().get(0).getName());
                if (response.isSuccessful()){
                    if (response.body() != null){
                        List<String> tables = new ArrayList<>();
                        List<Product> list = new ArrayList<>();

                        for (int i = 0; i < response.body().size(); i++) {
                            tables.add(response.body().get(i).getName());
                            list.add(response.body().get(i).getProduct());
                        }
                        productList.setValue(list);
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

    /**
     * Select product by name
     * @param select
     */
    public void setSelectedByName(String select){
        for (int i = 0; i < productList.getValue().size(); i++) {
            if(productList.getValue().get(i).getName().equalsIgnoreCase(select)){
                selectedProduct = productList.getValue().get(i);
            }
        }
    }

    /**
     * Select product by qr
     * @param qr
     */
    public void setSelectedByQr(int qr){
        for (int i = 0; i < productList.getValue().size(); i++) {
            if(productList.getValue().get(i).getqRCode() == qr){
                selectedProduct = productList.getValue().get(i);
            }
        }
    }

    /**
     * Get selected product
     * @return selectedProduct
     */
    public Product getSelected(){
        return selectedProduct;
    }
}
