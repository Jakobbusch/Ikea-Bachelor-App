package com.example.ikeabachelorapp;
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
    HashMap<String, List<String>> expandList;
    private String selected;
    private Product selectedProduct;

    private Repository(){
        productList = new MutableLiveData<List<Product>>();
        expandList = new HashMap<String, List<String>>();
    }

    public static synchronized Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public synchronized LiveData<List<Product>> getProducts(){
        return productList;
    }

    public HashMap<String, List<String>> getExpandList(){
        return expandList;
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
                        List<String> tables = new ArrayList<String>();
                        List<Product> list = new ArrayList<>();

                        for (int i = 0; i < response.body().size(); i++) {
                            tables.add(response.body().get(i).productName);
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
    public void setSelectedByName(String selected){
        for (int i = 0; i < productList.getValue().size(); i++) {
            System.out.println("Rep Chosen product: "+selected);
            System.out.println("Rep loop product: "+productList.getValue().get(i).productName);
            if(productList.getValue().get(i).productName.equalsIgnoreCase(selected)){
                selectedProduct = productList.getValue().get(i);
                System.out.println("Repository: products matched" + productList.getValue().get(i).getProductType());
            }
            System.out.println("Repository: No products matched");
        }
        this.selected = selected;
    }

    public void setSelectedByQr(int qr){
        for (int i = 0; i < productList.getValue().size(); i++) {
            System.out.println("Rep Chosen product: "+selected);
            System.out.println("Rep loop product: "+productList.getValue().get(i).productName);
            if(productList.getValue().get(i).getProductQRCode() == qr){
                selectedProduct = productList.getValue().get(i);
                System.out.println("Repository: products matched" + productList.getValue().get(i).getProductType());
            }
            System.out.println("Repository: No products matched");
        }
        this.selected = selected;
    }

    public Product getSelected(){
        return selectedProduct;
    }
}
