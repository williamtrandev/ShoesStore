package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.model.Size;
import com.trantanthanh.springcommerce.repository.SizeRepository;
import com.trantanthanh.springcommerce.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService implements ISizeService {
    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }
}
