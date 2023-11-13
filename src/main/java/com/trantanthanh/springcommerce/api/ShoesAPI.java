package com.trantanthanh.springcommerce.api;


import com.trantanthanh.springcommerce.api.requestDTO.FilterRequest;
import com.trantanthanh.springcommerce.api.requestDTO.ShoesRequest;
import com.trantanthanh.springcommerce.dto.ShoesDTO;
import com.trantanthanh.springcommerce.model.Shoes;
import com.trantanthanh.springcommerce.service.impl.ShoesService;
import com.trantanthanh.springcommerce.utils.Mapping;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ShoesAPI {
    private final ShoesService shoesService;

    @GetMapping("/shoes")
    public List<ShoesDTO> getAll() {
        return Mapping.convertToListShoesDTO(shoesService.getAll());
    }

    @GetMapping("/search")
    public List<ShoesDTO> searchByName(@RequestParam(name = "keyword") String name) {
        return Mapping.convertToListShoesDTO(shoesService.searchByName(name));
    }

    @PostMapping("/filter")
    public List<ShoesDTO> filter(@RequestBody FilterRequest request) {
        List<Shoes> filterShoes = shoesService.filter(request.getMinPrice(), request.getMaxPrice(),
                request.getBrandIds(), request.getColorIds());
        return Mapping.convertToListShoesDTO(filterShoes);
    }

    @PostMapping("/shoes")
    public ShoesDTO add(@RequestBody ShoesRequest request) {
        return Mapping.convertToShoesDTO(shoesService.insertOne(request));
    }
}
