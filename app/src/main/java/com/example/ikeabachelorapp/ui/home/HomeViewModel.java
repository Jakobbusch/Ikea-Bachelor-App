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
        urls.put("drawing","https://www.ikea.com/dk/da/images/products/friheten-hjornesovesofa-med-opbevaring-skiftebo-morkegra__0733170_pe738880_s5.jpg?f=xl");
        urls.put("front","https://www.ikea.com/dk/da/images/products/friheten-hjornesovesofa-med-opbevaring-skiftebo-morkegra__0175610_pe328883_s5.jpg?f=xl");

        rep = Repository.getInstance();
        product = rep.getSelected();
        mText = new MutableLiveData<>();
        if(product!= null){
            mText.setValue(product.productName +" " + product.getProductType());
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