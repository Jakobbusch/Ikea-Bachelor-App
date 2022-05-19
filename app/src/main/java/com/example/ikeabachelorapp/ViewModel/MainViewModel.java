package com.example.ikeabachelorapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ikeabachelorapp.Model.Product;
import com.example.ikeabachelorapp.Model.Repository;

import java.util.List;

public class MainViewModel extends ViewModel{

    private Repository repository;

    public MainViewModel() {
        repository = Repository.getInstance();
    }

    public LiveData<List<Product>> getProducts(){
        return repository.getProducts();
    }

    public void getProductList(){
        repository.getProductList();
    }

    public void setSelected(String selected){
        repository.setSelectedByName(selected);
    }


}
