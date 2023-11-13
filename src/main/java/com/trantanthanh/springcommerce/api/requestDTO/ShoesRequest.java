package com.trantanthanh.springcommerce.api.requestDTO;

import com.trantanthanh.springcommerce.dto.ShoesColorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoesRequest {
    @Data
    public static class Variation {
        private Long sizeId;
        private int stock;
    }
    @Data
    public static class ShoesColorJSON {
        private Long idColor;
        private String imagePath;
        private List<Variation> variationList;
    }
    private Long id;
    private Long categoryId;
    private double price;
    private String name;
    private Long brandId;
    private String description;
    private List<ShoesColorJSON> shoesColorJSONList;
}
