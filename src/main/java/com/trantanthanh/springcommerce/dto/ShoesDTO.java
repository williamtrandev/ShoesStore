package com.trantanthanh.springcommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoesDTO {
    private Long id;
    private Long categoryId;
    private double price;
    private String name;
    private Long brandId;
    private String description;
    private List<ShoesColorDTO> shoesColorDTOList;
}
