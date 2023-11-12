package com.trantanthanh.springcommerce.service;

import com.trantanthanh.springcommerce.model.Brand;
import com.trantanthanh.springcommerce.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();
}
