package com.trantanthanh.springcommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineDTO {
    private Long id;
    private Long shoesVariationId;
    private double price;
    private int quantity;
    private Long shoesOrderId;
    private ShoesVariationDTO shoesVariationDTO;
    private String imagePath;
    private String shoesName;
}
