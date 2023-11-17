package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.api.requestDTO.ShoesRequest;
import com.trantanthanh.springcommerce.model.*;
import com.trantanthanh.springcommerce.repository.*;
import com.trantanthanh.springcommerce.service.IShoesService;
import com.trantanthanh.springcommerce.utils.FileUploadUtil;
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
        if(shoes == null) return null;
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
        String uploadDir = "public/images";
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
            // File name có dạng Tên giày_Id mã màu
            String filename = shoes.getName().toLowerCase().replaceAll(" ", "")
                    + "_" + scJSON.getIdColor() + ".png";
            shoesColor.setImagePath(filename);
            // Decode ảnh dạng string sang ảnh gốc và Lưu ảnh vào folder
            FileUploadUtil.saveImageFromBase64(uploadDir, filename, scJSON.getImage());
            shoesColorList.add(shoesColor);
            shoesColorRepository.save(shoesColor);
            // List shoesVariation
            List<ShoesVariation> shoesVariationList = new ArrayList<>();
            // Insert cho từng variation
            for(Long sizeId : scJSON.getSizeList()) {
                Size size = sizeRepository.getReferenceById(sizeId);
                ShoesVariation shoesVariation = new ShoesVariation();
                shoesVariation.setShoesColor(shoesColor);
                shoesVariation.setSize(size);
                shoesVariationList.add(shoesVariation);
            }
            shoesVariationRepository.saveAll(shoesVariationList);
            shoesColor.setShoesVariationList(shoesVariationList);
        }
        shoesColorRepository.saveAll(shoesColorList);
        // Set List shoesColor
        shoes.setShoesColorList(shoesColorList);
        return shoesRepository.save(shoes);
    }
}
