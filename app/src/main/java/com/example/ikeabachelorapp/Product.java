package com.example.ikeabachelorapp;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("iD")
    private int iD;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    @SerializedName("price")
    private double price;

    @SerializedName("width")
    private double width;

    @SerializedName("height")
    private double height;

    @SerializedName("weight")
    private double weight;

    @SerializedName("image")
    private String image;

    @SerializedName("partAmount")
    private int partAmount;

    @SerializedName("color")
    private String color;

    @SerializedName("planImage")
    private String planImage;

    @SerializedName("qRCode")
    private int qRCode;

    @SerializedName("assembly")
    private Assembly assembly;

    public Product() {
    }

    public Product(int iD, String name, String type, double price, double width, double height, double weight,
                   String image, int partAmount, String color, String planImage, int qRCode, Assembly assembly) {
        this.iD = iD;
        this.name = name;
        this.type = type;
        this.price = price;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.image = image;
        this.partAmount = partAmount;
        this.color = color;
        this.planImage = planImage;
        this.qRCode = qRCode;
        this.assembly = assembly;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPartAmount() {
        return partAmount;
    }

    public void setPartAmount(int partAmount) {
        this.partAmount = partAmount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlanImage() {
        return planImage;
    }

    public void setPlanImage(String planImage) {
        this.planImage = planImage;
    }

    public int getqRCode() {
        return qRCode;
    }

    public void setqRCode(int qRCode) {
        this.qRCode = qRCode;
    }

    public Assembly getAssembly() {
        return assembly;
    }

    public void setAssembly(Assembly assembly) {
        this.assembly = assembly;
    }

    @Override
    public String toString() {
        return "Product{" +
                "iD=" + iD +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", width=" + width +
                ", height=" + height +
                ", weight=" + weight +
                ", image='" + image + '\'' +
                ", partAmount=" + partAmount +
                ", color='" + color + '\'' +
                ", planImage='" + planImage + '\'' +
                ", qRCode=" + qRCode +
                ", assembly=" + assembly +
                '}';
    }
}
