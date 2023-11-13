package com.trantanthanh.springcommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoesColorDTO {
    private Long id;
    private Long shoesId;
    private ColorDTO colorDTO;
    private String imagePath;
    private List<ShoesVariationDTO> shoesVariationDTOList;
}
