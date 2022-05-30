package com.example.ikeabachelorapp.Model;

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

    @SerializedName("text")
    private String text;

    @SerializedName("image")
    private String image;

    @SerializedName("image2")
    private String image2;

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

    /**
     * Constructor Empty
     */
    public Product() {
    }

    /**
     * Product Constructor
     * @param iD
     * @param name
     * @param type
     * @param price
     * @param width
     * @param height
     * @param weight
     * @param text
     * @param image
     * @param image2
     * @param partAmount
     * @param color
     * @param planImage
     * @param qRCode
     * @param assembly
     */
    public Product(int iD, String name, String type, double price, double width, double height, double weight, String text,
                   String image,String image2, int partAmount, String color, String planImage, int qRCode, Assembly assembly) {
        this.iD = iD;
        this.name = name;
        this.type = type;
        this.price = price;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.text = text;
        this.image = image;
        this.image2 = image2;
        this.partAmount = partAmount;
        this.color = color;
        this.planImage = planImage;
        this.qRCode = qRCode;
        this.assembly = assembly;

    }


    /**
     * Get id
     * @return iD
     */
    public int getiD() {
        return iD;
    }

    /**
     * Set id
     * @param iD
     */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * Get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Set type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get width
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set width
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Get height
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set height
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Get weight
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set weight
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Get image
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * Set image
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get Part Amount
     * @return partAmount
     */
    public int getPartAmount() {
        return partAmount;
    }

    /**
     * Set Part Amount
     * @param partAmount
     */
    public void setPartAmount(int partAmount) {
        this.partAmount = partAmount;
    }

    /**
     * Get color
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set color
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Get plan image
     * @return planImage
     */
    public String getPlanImage() {
        return planImage;
    }

    /**
     * Set plan image
     * @param planImage
     */
    public void setPlanImage(String planImage) {
        this.planImage = planImage;
    }

    /**
     * Get qr code
     * @return qRCode
     */
    public int getqRCode() {
        return qRCode;
    }

    /**
     * Set qr code
     * @param qRCode
     */
    public void setqRCode(int qRCode) {
        this.qRCode = qRCode;
    }

    /**
     * Get assembly class
     * @return assembly
     */
    public Assembly getAssembly() {
        return assembly;
    }

    /**
     * Set assembly class
     * @param assembly
     */
    public void setAssembly(Assembly assembly) {
        this.assembly = assembly;
    }

    /**
     * Get text
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Set text
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get image 2
     * @return image2
     */
    public String getImage2() {
        return image2;
    }

    /**
     * Set image 2
     * @param image2
     */
    public void setImage2(String image2) {
        this.image2 = image2;
    }

    /**
     *  Product toString
     * @return toString
     */
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
