package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.model.ShoesVariation;
import com.trantanthanh.springcommerce.repository.ShoesVariationRepository;
import com.trantanthanh.springcommerce.service.IShoesVariationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoesVariationService implements IShoesVariationService {
    @Autowired
    private ShoesVariationRepository shoesVariationRepository;
    @Override
    public ShoesVariation getById(Long id) {
        return shoesVariationRepository.getReferenceById(id);
    }
}
