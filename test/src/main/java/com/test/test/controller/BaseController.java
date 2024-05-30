package com.test.test.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.test.test.model.Customer;
import com.test.test.service.CustomerService;

public class BaseController {
  @Autowired
  protected CustomerService customerService;
  Customer currentCustomer;

  public BaseController(CustomerService customerService) {
    this.customerService = customerService;
  }

  protected void authorize(Long id) {
    if (!currentCustomer.getId().equals(id)) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
    }
  }

  protected boolean logIn(Long customerId, String contactMethodValue) {

    Optional<Customer> customer = this.customerService.getById(customerId);
    if (customer.isPresent() && customer.get().getContactValue().equals(contactMethodValue)) {
      currentCustomer = customer.get();
      return true;
    }
    return false;
  }

}