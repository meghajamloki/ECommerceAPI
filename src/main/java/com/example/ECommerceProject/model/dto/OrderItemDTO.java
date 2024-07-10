package com.example.ECommerceProject.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {

    private Integer productId;

    private Integer requestedQuantity;
}
