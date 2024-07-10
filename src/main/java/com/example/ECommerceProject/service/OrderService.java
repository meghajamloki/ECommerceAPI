package com.example.ECommerceProject.service;

import com.example.ECommerceProject.exception.CustomerNotFoundException;
import com.example.ECommerceProject.exception.ProductNotFoundException;
import com.example.ECommerceProject.model.Orders;
import com.example.ECommerceProject.model.dto.OrderRequestDTO;

public interface OrderService {

    Orders createOrder(OrderRequestDTO orders)throws CustomerNotFoundException, ProductNotFoundException;

}
