package guli.springframework.spring7restmvc.service;

import guli.springframework.spring7restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(UUID id);

}
