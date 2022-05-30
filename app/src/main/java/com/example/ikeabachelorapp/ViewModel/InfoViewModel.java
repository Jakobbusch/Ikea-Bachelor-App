package com.example.ikeabachelorapp.ViewModel;
import androidx.lifecycle.ViewModel;

import com.example.ikeabachelorapp.Model.Product;
import com.example.ikeabachelorapp.Model.Repository;

import java.util.HashMap;

public class InfoViewModel extends ViewModel {

    Repository rep;
    Product product;
    private HashMap<String,String> urls;

    /**
     * Constructor InfoViewModel
     */
    public InfoViewModel() {
        urls= new HashMap<>();
        rep = Repository.getInstance();
        product = rep.getSelected();
        urls.put("info",product.getPlanImage());
    }

    /**
     * Get product
     * @return product
     */
    public Product getProduct(){
        return product;
    }

    /**
     * Get URL
     * @return urls
     */
    public HashMap<String,String> getUrl(){

        return urls;
    }
}