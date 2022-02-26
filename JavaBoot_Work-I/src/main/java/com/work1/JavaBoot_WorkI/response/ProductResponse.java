package com.work1.JavaBoot_WorkI.response;

import com.work1.JavaBoot_WorkI.entity.Product;
public class ProductResponse {
    private int id;
    private int productId;
    private String productName;
    private double productPrice;
    private double productDiscount;
    private String description;
    private String productBand;
    private String productSize;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductBand() {
        return productBand;
    }

    public void setProductBand(String productBand) {
        this.productBand = productBand;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ProductResponse() {
    }

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productDiscount = product.getProductDiscount();
        this.description = product.getDescription();
        this.productBand = product.getProductBand();
        this.productSize = product.getProductSize();
        this.color = product.getColor();
    }
}
