package com.example.ECommerceProject.service.impl;

import com.example.ECommerceProject.model.Customer;
import com.example.ECommerceProject.repository.CustomerRepository;
import com.example.ECommerceProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }
}
