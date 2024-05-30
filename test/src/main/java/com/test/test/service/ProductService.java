package com.test.test.service;

import com.test.test.model.Product;
import com.test.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }


}
