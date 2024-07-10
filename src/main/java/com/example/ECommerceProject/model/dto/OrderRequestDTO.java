package com.example.ECommerceProject.model.dto;

import com.example.ECommerceProject.model.Address;
import com.example.ECommerceProject.model.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDTO {

    private Address address;

    private Integer customerId;

    private Payment payment;

    private List<OrderItemDTO> items;
}
