package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.model.Color;
import com.trantanthanh.springcommerce.repository.ColorRepository;
import com.trantanthanh.springcommerce.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService implements IColorService {
    @Autowired
    private ColorRepository colorRepository;
    @Override
    public List<Color> getAll() {
        return colorRepository.findAll();
    }
}
