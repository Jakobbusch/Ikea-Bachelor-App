package com.example.ikeabachelorapp;


import com.google.gson.annotations.SerializedName;

public class ResponseTesttable {


    @SerializedName("id")
    public Long id;

    @SerializedName("varTest")
    public String varTest;


    @SerializedName("intTest")
    public int intTest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVarTest() {
        return varTest;
    }

    public void setVarTest(String varTest) {
        this.varTest = varTest;
    }

    public int getIntTest() {
        return intTest;
    }

    public void setIntTest(int intTest) {
        this.intTest = intTest;
    }
}
