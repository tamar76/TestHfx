package com.test.test.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.test.test.mock.MockDataGenerator;
import com.test.test.model.Product;
import com.test.test.model.ProductToCustomerModel;
import com.test.test.model.ProductsToCustomer;

@Repository
public class ProductsToCustomerRepository {
    public ProductsToCustomerRepository(ProductRepository productRepository) {
        this.productsToCustomers = MockDataGenerator.generateMockProductsToCustomers();
        this.counter = new AtomicLong(productsToCustomers.size());
        this._productRepository = productRepository;
    }

    private ProductRepository _productRepository;
    private final List<ProductsToCustomer> productsToCustomers;

    private final AtomicLong counter;

    public List<ProductsToCustomer> getAll() {
        return productsToCustomers;
    }

    public List<ProductToCustomerModel> getProductsByCustomerId(Long customerId) {

        // Filter productsToCustomers by customerId and get the productIds
        List<Long> productIds = productsToCustomers.stream()
                .filter(ptc -> ptc.getCustomerId().equals(customerId))
                .map(ProductsToCustomer::getProductId)
                .collect(Collectors.toList());

        // Retrieve products by productIds
        List<Product> products = _productRepository.getByIds(productIds);

        // Create a map for quick lookup of products by their IDs
        Map<Long, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getId, product -> product));

        // Map the ProductsToCustomer to ProductToCustomerModel
        List<ProductToCustomerModel> result = productsToCustomers.stream()
                .filter(ptc -> ptc.getCustomerId().equals(customerId))
                .map(ptc -> {
                    Product product = productMap.get(ptc.getProductId());
                    return new ProductToCustomerModel(
                            ptc.getId(),
                            ptc.getProductId(),
                            ptc.getCustomerId(),
                            ptc.getCount(),
                            product.getPrice(),
                            product.getContactValue());
                })
                .collect(Collectors.toList());

        return result;
    }

    public void deleteByCustomerId(Long customerId, Long productId) {
        productsToCustomers
                .removeIf(ptc -> ptc.getCustomerId().equals(customerId) && ptc.getProductId().equals(productId));
    }

    public void addProductsToCustomerById(Long customerId, List<Long> productIds) {
        for (Long productId : productIds) {
            Optional<ProductsToCustomer> existingEntry = productsToCustomers.stream()
                    .filter(ptc -> ptc.getCustomerId().equals(customerId) && ptc.getProductId().equals(productId))
                    .findFirst();

            if (existingEntry.isPresent()) {
                existingEntry.get().setCount(existingEntry.get().getCount() + 1);
            } else {
                ProductsToCustomer newEntry = new ProductsToCustomer(counter.incrementAndGet(), productId, customerId,
                        1);
                productsToCustomers.add(newEntry);
            }
        }
    }

    public void updateProductsToCustomer(Long customerId, Long productId, int newCount) {
        Optional<ProductsToCustomer> existingEntry = productsToCustomers.stream()
                .filter(ptc -> ptc.getCustomerId().equals(customerId) &&
                        ptc.getProductId().equals(productId))
                .findFirst();

        if (existingEntry.isPresent()) {
            existingEntry.get().setCount(newCount);
        } else {
            ProductsToCustomer newEntry = new ProductsToCustomer(counter.incrementAndGet(), productId, customerId,
                    newCount);
            productsToCustomers.add(newEntry);
        }

    }

    public List<Product> OfferingProductsToTheCustomer(Long customerId) {

        List<Long> purchasedProductIds = productsToCustomers.stream()
                .filter(ptc -> ptc.getCustomerId().equals(customerId))
                .map(ProductsToCustomer::getProductId)
                .collect(Collectors.toList());

        return _productRepository.getAll().stream()
                .filter(product -> !purchasedProductIds.contains(product.getId()))
                .collect(Collectors.toList());
    }
}
