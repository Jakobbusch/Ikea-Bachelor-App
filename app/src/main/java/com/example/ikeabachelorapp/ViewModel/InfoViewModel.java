package com.example.ikeabachelorapp.ViewModel;
import androidx.lifecycle.ViewModel;

import com.example.ikeabachelorapp.Model.Product;
import com.example.ikeabachelorapp.Model.Repository;

public class InfoViewModel extends ViewModel {

    Repository rep;
    Product p;

    public InfoViewModel() {
        rep = Repository.getInstance();
        p = rep.getSelected();

    }
    public Product getProduct(){
        return p;
    }
}