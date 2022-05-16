package com.example.ikeabachelorapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.List;

public class AppViewModel extends ViewModel{

    Repository repository;

    public AppViewModel() {
        repository = Repository.getInstance();
    }

    LiveData<List<Product>> getProducts(){
        return repository.getProducts();
    }

    public void setSelected(String selected){
        repository.setSelected(selected);
    }


}
