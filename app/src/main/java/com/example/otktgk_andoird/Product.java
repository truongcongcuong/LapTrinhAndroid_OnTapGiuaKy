package com.example.otktgk_andoird;

import java.io.Serializable;

public class Product implements Serializable {
    private String productName;
    private double price;
    private int image;

    public Product() {
    }

    public Product(String productName, double price, int image) {
        this.productName = productName;
        this.price = price;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
