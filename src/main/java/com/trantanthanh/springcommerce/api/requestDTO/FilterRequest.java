package com.trantanthanh.springcommerce.api.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterRequest {
    private double minPrice;
    private double maxPrice;
    private List<Long> brandIds;
    private List<Long> colorIds;
}
