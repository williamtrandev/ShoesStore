package com.trantanthanh.springcommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoesVariationDTO {
    private Long id;
    private Long shoesColorId;
    private Long sizeId;
    private int stock;
}
