package com.example.ikeabachelorapp.ui.assembly;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class assemblyViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public assemblyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Assembly fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}