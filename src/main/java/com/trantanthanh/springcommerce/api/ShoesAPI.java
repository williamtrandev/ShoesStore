package com.trantanthanh.springcommerce.api;


import com.trantanthanh.springcommerce.api.requestDTO.FilterRequest;
import com.trantanthanh.springcommerce.api.requestDTO.ShoesRequest;
import com.trantanthanh.springcommerce.dto.ShoesDTO;
import com.trantanthanh.springcommerce.dto.ShoesVariationDTO;
import com.trantanthanh.springcommerce.model.Shoes;
import com.trantanthanh.springcommerce.model.ShoesVariation;
import com.trantanthanh.springcommerce.repository.ShoesVariationRepository;
import com.trantanthanh.springcommerce.service.impl.ShoesService;
import com.trantanthanh.springcommerce.utils.Mapping;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/shoes")
public class ShoesAPI {
    private final ShoesService shoesService;
    private final ShoesVariationRepository shoesVariationRepository;

    @GetMapping({"", "/"})
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

    @PostMapping({"", "/"})
    public ShoesDTO add(@RequestBody ShoesRequest request) {
        return Mapping.convertToShoesDTO(shoesService.insertOne(request));
    }

    @GetMapping("/variation/{idShoesColor}")
    public List<ShoesVariationDTO> getVariation(@PathVariable(name = "idShoesColor") Long id) {
        return Mapping.convertToListShoesVariationDTO(shoesVariationRepository.findAllWithSize(id));
    }

    @DeleteMapping("/{idShoes}")
    public ResponseEntity<?> delete(@PathVariable(name = "idShoes") Long id) {
        Shoes shoes = shoesService.getOne(id);
        if(shoes != null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shoes not found");
    }
}
