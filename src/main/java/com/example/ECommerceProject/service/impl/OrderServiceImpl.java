package com.example.ECommerceProject.service.impl;

import com.example.ECommerceProject.exception.CustomerNotFoundException;
import com.example.ECommerceProject.exception.ProductNotFoundException;
import com.example.ECommerceProject.model.*;
import com.example.ECommerceProject.model.dto.OrderItemDTO;
import com.example.ECommerceProject.model.dto.OrderRequestDTO;
import com.example.ECommerceProject.repository.CustomerRepository;
import com.example.ECommerceProject.repository.OrderRepository;
import com.example.ECommerceProject.repository.ProductRepository;
import com.example.ECommerceProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Orders createOrder(OrderRequestDTO orderRequest)throws CustomerNotFoundException, ProductNotFoundException {

        Integer customerId = orderRequest.getCustomerId();
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("No customer found with ID " + customerId);

        }

        Customer customer = optionalCustomer.get();

        Orders orders = new Orders();
        orders.setCustomer(customer);
        orders.setShippingAddress(orderRequest.getAddress());
        orders.setStatus(Status.CREATED);
        orders.setCreatedAt(LocalDateTime.now());

        Payment processedPayment = processPayment(orderRequest.getPayment());
        orders.setPayment(processedPayment);

        Set<OrderItem> itemList = new HashSet<>();
        for(OrderItemDTO item : orderRequest.getItems()){
           Optional<Product> productOptional = productRepository.findById(item.getProductId());
           if(productOptional.isEmpty()){
               throw new ProductNotFoundException("No product found with ID " + item.getProductId());
           }
           Product product = productOptional.get();

           OrderItem i = new OrderItem();
           i.setProduct(product);
           i.setOrder(orders);
           i.setOrderedQuantity(item.getRequestedQuantity());
           itemList.add(i);
        }
        orders.setItems(itemList);

        Orders savedOrder = orderRepository.save(orders);
        return  savedOrder;
    }

    private Payment processPayment(Payment payment) {
        // calling a 3rd party api and getting a confirmation code

        payment.setConfirmationCode("UTYV445");
        return payment;
    }
}
