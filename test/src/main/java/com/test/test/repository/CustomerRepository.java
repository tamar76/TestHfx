package com.test.test.repository;

import com.test.test.mock.MockDataGenerator;
import com.test.test.model.Customer;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CustomerRepository {

    private final List<Customer> customers = MockDataGenerator.generateMockCustomers();
    private final AtomicLong counter = new AtomicLong(customers.size());

  

    public Optional<Customer> getById(Long id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(counter.incrementAndGet());
            customers.add(customer);
        } else {
            boolean customerExists = customers.stream()
                    .anyMatch(existingCustomer -> existingCustomer.getId().equals(customer.getId()));
            if (!customerExists) {
                customers.add(customer);
            }
        }
        return customer;
    }
  
      
        public boolean isCustomerPresent( 
            Long id) {
            Optional<Customer> customer = customers.stream()
                    .filter(c -> c.getId().equals(id))
                    .findFirst();
    
            return customer.isPresent();
        }
    }
    
    

