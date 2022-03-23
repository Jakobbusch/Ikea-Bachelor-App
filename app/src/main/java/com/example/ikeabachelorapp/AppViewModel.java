package com.example.ikeabachelorapp;

import androidx.lifecycle.ViewModel;
public class AppViewModel extends ViewModel{

    Repository repository;

    public AppViewModel() {
        repository = Repository.getInstance();
    }
}
