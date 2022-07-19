package com.example.motex.models;

public class Product {
    private int id;
    private int image;
    private String name;
    private String price;
    private String maxPrice;

    public Product() {
    }

    public Product(int id, int image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    public Product(int id, int image, String name, String price, String maxPrice) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.maxPrice = maxPrice;
    }

    public int getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
