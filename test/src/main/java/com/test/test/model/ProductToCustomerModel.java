package com.test.test.model;

public class ProductToCustomerModel {
    private Long id;
    private Long productId;
    private Long customerId;
    private int count;
    private String name;
    private double price;

    public ProductToCustomerModel(Long id, Long productId, Long customerId, int count, double price, String name) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productId = productId;
        this.customerId = customerId;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public void setContactValue(String name) {
        this.name = name;
    }

    public String getContactValue() {
        return this.name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
