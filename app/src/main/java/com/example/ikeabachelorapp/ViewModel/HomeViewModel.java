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

    /**
     * Constructor HomeViewModel
     */
    public HomeViewModel() {
        urls= new HashMap<>();
        rep = Repository.getInstance();
        product = rep.getSelected();
        System.out.println("&Home: " +product.getPlanImage());
        urls.put("front2",product.getImage2());
        urls.put("front",product.getImage());
        nameHeader = new MutableLiveData<>();
        if(product!= null){
            nameHeader.setValue(product.getName());
        }
    }

    /**
     * Get product
     * @return product
     */
    public Product getProduct(){
        return product;
    }

    /**
     * Get name header
     * @return nameHeader
     */
    public LiveData<String> getNameHeader() {
        return nameHeader;
    }

    /**
     * Get URL
     * @return urls
     */
    public HashMap<String,String> getUrl(){

        return urls;
    }
}