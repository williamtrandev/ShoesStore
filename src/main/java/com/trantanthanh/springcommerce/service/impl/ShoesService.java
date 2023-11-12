package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.model.Shoes;
import com.trantanthanh.springcommerce.repository.ShoesRepository;
import com.trantanthanh.springcommerce.service.IShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoesService implements IShoesService {
    @Autowired
    private ShoesRepository shoesRepository;
    @Override
    public List<Shoes> getAll() {
        return shoesRepository.findAll();
    }

    @Override
    public List<Shoes> getAllWithColor() {
        return shoesRepository.findAllShoesWithColors();
    }
}
