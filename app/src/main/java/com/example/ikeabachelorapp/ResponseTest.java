package com.example.ikeabachelorapp;


import com.google.gson.annotations.SerializedName;

public class ResponseTest {


    @SerializedName("test")
    private String test;

    public Test getTest() {
        return new Test(test);
    }

}
