package com.example.ikeabachelorapp.ui.info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ikeabachelorapp.Product;
import com.example.ikeabachelorapp.Repository;

public class infoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    Repository rep;
    Product p;

    public infoViewModel() {
        rep = Repository.getInstance();
        mText = new MutableLiveData<>();
        mText.setValue("This is Info fragment");
        p = rep.getSelected();
        System.out.println("From info: "+p.toString());
    }

    public LiveData<String> getText() {
        return mText;
    }

    public Product getProduct(){
        return p;
    }

}