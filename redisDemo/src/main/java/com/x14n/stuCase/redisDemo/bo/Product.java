package com.x14n.stuCase.redisDemo.bo;

public class Product {

    private Integer id;

    private String brand;

    private String color;

    private String size;

    private double price;

    private String img;

    public Product(Integer id, String brand, String color, String size, double price, String img) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
        this.img = img;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                '}';
    }
}
