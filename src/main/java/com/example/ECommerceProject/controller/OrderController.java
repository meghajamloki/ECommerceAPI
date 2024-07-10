package com.example.ECommerceProject.controller;

import com.example.ECommerceProject.exception.CustomerNotFoundException;
import com.example.ECommerceProject.exception.ProductNotFoundException;
import com.example.ECommerceProject.model.Orders;
import com.example.ECommerceProject.model.dto.OrderRequestDTO;
import com.example.ECommerceProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Orders createOrder(@RequestBody OrderRequestDTO orderRequest)throws CustomerNotFoundException, ProductNotFoundException {
        Orders savedOrder = orderService.createOrder(orderRequest);
        return  savedOrder;
    }
}
