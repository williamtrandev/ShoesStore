package com.trantanthanh.springcommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    private Long id;
    private Long shoesVariationId;
    private ShoesVariationDTO shoesVariationDTO;
    private Long customerId;
    private CustomerDTO customerDTO;
    private int quantity;
    private double price;
}
