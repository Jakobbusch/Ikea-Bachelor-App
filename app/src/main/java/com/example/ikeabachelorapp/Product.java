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

    @SerializedName("productImage")
    private String productImage;

    @SerializedName("productPartAmount")
    private int productPartAmount;

    @SerializedName("productColor")
    private String productColor;

    @SerializedName("productPlanImage")
    private String productPlanImage;

    @SerializedName("productQRCode")
    private int productQRCode;

    public Product() {
    }

    public Product(int productID, String productName, String productType, double productPrice, double productWidth, double productHeight, double productWeight,
                   String productImage, int productPartAmount,String productColor,String productPlanImage, int productQRCode) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productWidth = productWidth;
        this.productHeight = productHeight;
        this.productWeight = productWeight;
        this.productImage = productImage;
        this.productPartAmount = productPartAmount;
        this.productColor = productColor;
        this.productPlanImage = productPlanImage;
        this.productQRCode = productQRCode;
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

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductPartAmount() {
        return productPartAmount;
    }

    public void setProductPartAmount(int productPartAmount) {
        this.productPartAmount = productPartAmount;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductPlanImage() {
        return productPlanImage;
    }

    public void setProductPlanImage(String productPlanImage) {
        this.productPlanImage = productPlanImage;
    }

    public int getProductQRCode() {
        return productQRCode;
    }

    public void setProductQRCode(int productQRCode) {
        this.productQRCode = productQRCode;
    }

    public String toString(){
        return "ID: "+ productID+ " ProductName: "+productName + " Product Price: "+ productPrice + " ProductWidth "+ productWidth + " ProductHeight: "+ productHeight + " ProductWeight "+productWeight;
    }

}
