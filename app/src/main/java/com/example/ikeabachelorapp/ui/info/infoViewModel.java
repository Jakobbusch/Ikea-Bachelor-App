package com.example.ikeabachelorapp.ui.info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ikeabachelorapp.Product;
import com.example.ikeabachelorapp.Repository;

public class infoViewModel extends ViewModel {

    Repository rep;
    Product p;

    public infoViewModel() {
        rep = Repository.getInstance();
        p = rep.getSelected();

    }


    public Product getProduct(){
        return p;
    }

}