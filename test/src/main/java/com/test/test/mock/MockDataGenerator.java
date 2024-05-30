package com.test.test.mock;

import java.util.ArrayList;
import java.util.List;

import com.test.test.model.Customer;
import com.test.test.model.Product;
import com.test.test.model.ProductsToCustomer;
import com.test.test.model.enums.ContactMethodType;

public class MockDataGenerator {

    public static List<Customer> generateMockCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(12,"0504321243",ContactMethodType.PHONE));
        customers.add(new Customer(13,"0502437668",ContactMethodType.PHONE));
        customers.add(new Customer(14,"client.@gmail.com",ContactMethodType.EMAIL));
   
        return customers;
    }

    public static List<Product> generateMockProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(20, "Tablet", 2000));
        products.add(new Product(30, "Headphones", 800));
        products.add(new Product(40, "keyboard",300 ));
        products.add(new Product(50, "Calculator", 100));
        products.add(new Product(60, "Computer", 4000));
       
        return products;
    }

    public static List<ProductsToCustomer> generateMockProductsToCustomers() {
        List<ProductsToCustomer> productsToCustomers = new ArrayList<>();
        productsToCustomers.add(new ProductsToCustomer(100, 60, 12,1));
        productsToCustomers.add(new ProductsToCustomer(101, 30, 13,3));
        productsToCustomers.add(new ProductsToCustomer(102, 40, 14,4));
        productsToCustomers.add(new ProductsToCustomer(103, 60, 13,2));

        return productsToCustomers;
    }
}
