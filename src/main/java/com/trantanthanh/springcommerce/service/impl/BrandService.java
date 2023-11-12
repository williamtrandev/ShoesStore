package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.model.Brand;
import com.trantanthanh.springcommerce.repository.BrandRepository;
import com.trantanthanh.springcommerce.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
}
