package com.test.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductsToCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Long customerId;
    private int count;

    public ProductsToCustomer(long id, long productId, long customerId, int count) {
        this.id = id;
        this.productId = productId;
        this.customerId = customerId;
        this.count = count;
    }

    public ProductsToCustomer() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCustomerId(Long id) {
        this.customerId = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setProductId(Long id) {
        this.productId = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
