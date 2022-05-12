package com.example.ikeabachelorapp.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.ikeabachelorapp.Model.Repository;

public class AppViewModel extends ViewModel{

    Repository repository;

    public AppViewModel() {
        repository = Repository.getInstance();
    }
}
