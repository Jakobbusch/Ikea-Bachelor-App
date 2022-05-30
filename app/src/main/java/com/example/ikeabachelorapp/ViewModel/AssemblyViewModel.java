package com.example.ikeabachelorapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ikeabachelorapp.Model.Product;
import com.example.ikeabachelorapp.Model.Repository;

public class AssemblyViewModel extends ViewModel {

    private Product product;

    Repository rep;

    /**
     * Constructor AssemblyViewModel
     */
    public AssemblyViewModel() {
        rep = Repository.getInstance();
        product = rep.getSelected();
    }

    /**
     * Get product
     * @return product
     */
    public Product getProduct(){
        return product;
    }
}