package com.example.ikeabachelorapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ikeabachelorapp.Model.Product;
import com.example.ikeabachelorapp.Model.Repository;

import java.util.HashMap;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> nameHeader;
    Repository rep;
    Product product;
    private HashMap<String,String> urls;

    public HomeViewModel() {
        urls= new HashMap<>();
        rep = Repository.getInstance();
        product = rep.getSelected();
        System.out.println("&Home: " +product.getPlanImage());
        urls.put("drawing",product.getPlanImage());
        urls.put("front",product.getImage());
        nameHeader = new MutableLiveData<>();
        if(product!= null){
            nameHeader.setValue(product.getName());
        }
    }

    public LiveData<String> getNameHeader() {
        return nameHeader;
    }

    public HashMap<String,String> getUrl(){

        return urls;
    }
}