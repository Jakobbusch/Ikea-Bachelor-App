package com.example.ikeabachelorapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Test {
    @SerializedName("test")
    private final String test;

    public Test(String test){

        this.test = test;
    }

        public String getTest(){
        return test;
    }
}
