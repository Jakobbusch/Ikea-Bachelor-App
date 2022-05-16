package com.example.ikeabachelorapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("productID")
    public int productID;

    @SerializedName("productName")
    public String productName;

    @SerializedName("productType")
    public String productType;

    @SerializedName("productPrice")
    public double productPrice;

    @SerializedName("productWidth")
    public double productWidth;

    @SerializedName("productHeight")
    public double productHeight;

    @SerializedName("productWeight")
    public double productWeight;

    public Product() {
    }

    public Product(int productID, String productName, String productType, double productPrice, double productWidth, double productHeight, double productWeight) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productWidth = productWidth;
        this.productHeight = productHeight;
        this.productWeight = productWeight;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(double productWidth) {
        this.productWidth = productWidth;
    }

    public double getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(double productHeight) {
        this.productHeight = productHeight;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
    }

    public String toString(){
        return "ID: "+ productID+ " ProductName: "+productName + " Product Price: "+ productPrice + " ProductWidth "+ productWidth + " ProductHeight: "+ productHeight + " ProductWeight "+productWeight;
    }

}
