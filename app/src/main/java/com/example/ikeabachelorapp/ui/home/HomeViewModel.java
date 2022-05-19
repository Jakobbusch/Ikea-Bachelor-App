package com.example.ikeabachelorapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ikeabachelorapp.Product;
import com.example.ikeabachelorapp.Repository;

import java.util.HashMap;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> hText;
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
        mText = new MutableLiveData<>();
        if(product!= null){
            mText.setValue(product.getName());
        }

        hText = new MutableLiveData<>();
        hText.setValue("Testtext");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public HashMap<String,String> getUrl(){

        return urls;
    }
}