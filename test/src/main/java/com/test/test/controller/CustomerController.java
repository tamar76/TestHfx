package com.test.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.test.model.Customer;
import com.test.test.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseController {

    public CustomerController(CustomerService customerService) {
        super(customerService);
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public boolean logIn(@PathVariable Long id, @RequestParam String contactValue) {
        return super.logIn(id, contactValue);
    }

    @PostMapping
    public Customer sighnIn(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
}
