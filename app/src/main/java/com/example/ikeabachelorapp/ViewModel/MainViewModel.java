package com.example.ikeabachelorapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ikeabachelorapp.Model.Product;
import com.example.ikeabachelorapp.Model.Repository;

import java.util.List;

public class MainViewModel extends ViewModel{

    private Repository repository;

    /**
     * Constructor MainViewModel
     */
    public MainViewModel() {
        repository = Repository.getInstance();
    }

    /**
     * Get product list
     * @return repository.getProducts()
     */
    public LiveData<List<Product>> getProducts(){
        return repository.getProducts();
    }

    /**
     * Get productList
     */
    public void getProductList(){
        repository.getProductList();
    }

    /**
     * Set selected
     * @param selected
     */
    public void setSelected(String selected){
        repository.setSelectedByName(selected);
    }


}
