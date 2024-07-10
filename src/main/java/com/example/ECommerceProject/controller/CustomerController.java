package com.example.ECommerceProject.controller;

import com.example.ECommerceProject.model.Customer;
import com.example.ECommerceProject.repository.CustomerRepository;
import com.example.ECommerceProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.registerCustomer(customer);
        return savedCustomer;
    }
}
