package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.api.requestDTO.ShoesRequest;
import com.trantanthanh.springcommerce.dto.ShoesDTO;
import com.trantanthanh.springcommerce.model.*;
import com.trantanthanh.springcommerce.repository.*;
import com.trantanthanh.springcommerce.service.IShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoesService implements IShoesService {
    @Autowired
    private ShoesRepository shoesRepository;

    @Autowired
    private ShoesColorRepository shoesColorRepository;

    @Autowired
    private ShoesVariationRepository shoesVariationRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Shoes> getAll() {
        return shoesRepository.findAll();
    }

    @Override
    public List<Shoes> getAllWithColor() {
        return shoesRepository.findAllShoesWithColors();
    }

    @Override
    public Shoes getOne(Long id) {
        Shoes shoes = shoesRepository.findOneWithColors(id);

        for(ShoesColor shoesColor : shoes.getShoesColorList()) {
            // Get list of shoes variations in each shoes color
            List<ShoesVariation> shoesVariationList = shoesVariationRepository.findAllWithSize(shoesColor.getId());
            // Set list of shoes variations
            shoesColor.setShoesVariationList(shoesVariationList);
        }

        return shoes;
    }

    // API
    @Override
    public List<Shoes> searchByName(String name) {
        return shoesRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Shoes> filter(double minPrice, double maxPrice, List<Long> brandIds, List<Long> colorIds) {
        return shoesRepository.findAll(
                ShoesSpecifications.priceBetweenAndBrandIdAndColorId(minPrice, maxPrice, brandIds, colorIds));
    }

    @Override
    public Shoes insertOne(ShoesRequest request) {
        Brand brand = brandRepository.getReferenceById(request.getBrandId());
        Category category = categoryRepository.getReferenceById(request.getCategoryId());
        Shoes shoes = new Shoes();
        shoes.setName(request.getName());
        shoes.setPrice(request.getPrice());
        shoes.setDescription(request.getDescription());
        shoes.setBrand(brand);
        shoes.setCategory(category);
        // Lưu shoes vào trước
        shoesRepository.save(shoes);
        // List các shoesColor
        List<ShoesColor> shoesColorList = new ArrayList<>();
        // Insert các shoesColor
        for(ShoesRequest.ShoesColorJSON scJSON : request.getShoesColorJSONList()) {
            Color color = colorRepository.getReferenceById(scJSON.getIdColor());
            ShoesColor shoesColor = new ShoesColor();
            shoesColor.setShoes(shoes);
            shoesColor.setColor(color);
            shoesColor.setImagePath(scJSON.getImagePath());
            shoesColorList.add(shoesColor);
            shoesColorRepository.save(shoesColor);
            // List shoesVariation
            List<ShoesVariation> shoesVariationList = new ArrayList<>();
            // Insert cho từng variation
            for(ShoesRequest.Variation variation : scJSON.getVariationList()) {
                Size size = sizeRepository.getReferenceById(variation.getSizeId());
                ShoesVariation shoesVariation = new ShoesVariation();
                shoesVariation.setShoesColor(shoesColor);
                shoesVariation.setSize(size);
                shoesVariation.setStock(variation.getStock());
                shoesVariationList.add(shoesVariation);
            }
            shoesVariationRepository.saveAll(shoesVariationList);
            shoesColor.setShoesVariationList(shoesVariationList);
            shoesColorRepository.save(shoesColor);
        }
        // Set List shoesColor
        shoes.setShoesColorList(shoesColorList);
        return shoesRepository.save(shoes);
    }
}
