package com.test.test.service;

import com.test.test.model.Product;
import com.test.test.model.ProductToCustomerModel;
import com.test.test.model.ProductsToCustomer;
import com.test.test.repository.ProductsToCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsToCustomerService {

    @Autowired
    private final ProductsToCustomerRepository productsToCustomerRepository;

    
    public ProductsToCustomerService(ProductsToCustomerRepository productsToCustomerRepository) {
        this.productsToCustomerRepository = productsToCustomerRepository;
    }



    public  List<ProductToCustomerModel> getProductsByCustomerId(Long customerId) {
        return productsToCustomerRepository.getProductsByCustomerId(customerId);
    }

    public void addProductsToCustomerById(Long customerId, List<Long> productIds) {
        productsToCustomerRepository.addProductsToCustomerById(customerId, productIds);
    }


    public void updateProductsToCustomer(Long customerId, Long productId, int newCount) {
        productsToCustomerRepository.updateProductsToCustomer(customerId, productId, newCount);
    }


    public List<Product> getOfferingProductsToCustomer(Long customerId) {
        return productsToCustomerRepository.OfferingProductsToTheCustomer(customerId);
    }

    public void deleteById(Long customerId, Long productId) {
        productsToCustomerRepository.deleteByCustomerId(customerId, productId);
    }
  
}
