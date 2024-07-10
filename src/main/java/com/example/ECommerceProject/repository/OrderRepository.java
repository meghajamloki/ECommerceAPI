package com.example.ECommerceProject.repository;

import com.example.ECommerceProject.model.Orders;
import com.example.ECommerceProject.model.dto.OrderItemDTO;
import com.example.ECommerceProject.model.dto.OrderRequestDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
}
