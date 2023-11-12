package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.model.Category;
import com.trantanthanh.springcommerce.repository.CategoryRepository;
import com.trantanthanh.springcommerce.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
