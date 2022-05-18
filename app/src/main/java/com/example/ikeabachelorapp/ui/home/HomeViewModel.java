package com.example.ikeabachelorapp.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ikeabachelorapp.Product;
import com.example.ikeabachelorapp.Repository;
import com.example.ikeabachelorapp.productpage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.http.Url;

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

        System.out.println("&Home: " +product.getProductPlanImage());
        urls.put("drawing",product.getProductPlanImage());
        urls.put("front",product.getProductImage());
        mText = new MutableLiveData<>();
        if(product!= null){
            mText.setValue(product.productName);
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