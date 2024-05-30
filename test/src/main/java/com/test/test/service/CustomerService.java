package com.test.test.service;

import com.test.test.model.Customer;
import com.test.test.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> getById(Long id) {
        return customerRepository.getById(id);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public boolean isCustomerPresent(Long Id) {
        return customerRepository.isCustomerPresent(Id);
    }

}
