package com.trantanthanh.springcommerce.api.requestDTO;

import com.trantanthanh.springcommerce.dto.ShoesColorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoesRequest {
    @Data
    public static class ShoesColorJSON {
        private Long idColor;
        private String image;
        private List<Long> sizeList;
    }
    private Long id;
    private Long categoryId;
    private double price;
    private String name;
    private Long brandId;
    private String description;
    private List<ShoesColorJSON> shoesColorJSONList;
}
