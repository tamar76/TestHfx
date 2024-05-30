package com.test.test.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.test.model.Product;
import com.test.test.model.ProductToCustomerModel;
import com.test.test.service.CustomerService;
import com.test.test.service.ProductsToCustomerService;

@RestController
@RequestMapping("/products")

public class ProductsToCustomerController extends BaseController {

    @Autowired
    private final ProductsToCustomerService productsToCustomerService;

    public ProductsToCustomerController(ProductsToCustomerService productsToCustomerService,
            CustomerService customerService) {
        super(customerService);
        this.productsToCustomerService = productsToCustomerService;
    }

    @GetMapping("/customer/{customerId}")
    public List<ProductToCustomerModel> getProductsByCustomerId(@PathVariable Long customerId) {
        authorize(customerId);
        return productsToCustomerService.getProductsByCustomerId(customerId);
    }

    @PostMapping("/customer/{customerId}/add")
    public void addProductsToCustomerById(@PathVariable Long customerId, @RequestBody List<Long> productIds) {
        authorize(customerId);
        productsToCustomerService.addProductsToCustomerById(customerId, productIds);
    }

    @PutMapping("/customer/{customerId}/update")
    public void updateProductsToCustomer(@PathVariable Long customerId, @RequestParam Long productId,
            @RequestParam int newCount) {
        authorize(customerId);
        productsToCustomerService.updateProductsToCustomer(customerId, productId, newCount);
    }

    @GetMapping("/customer/{customerId}/offering")
    public List<Product> getOfferingProductsToCustomer(@PathVariable Long customerId) {
        authorize(customerId);
        return productsToCustomerService.getOfferingProductsToCustomer(customerId);
    }

    @GetMapping("/customer/{customerId}/delete")
    public void deleteById(@PathVariable Long customerId, @RequestParam Long productId) {
        authorize(customerId);
        productsToCustomerService.deleteById(customerId, productId);
    }

}
