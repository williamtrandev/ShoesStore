package com.trantanthanh.springcommerce.service;

import com.trantanthanh.springcommerce.model.Shoes;

import java.util.List;

public interface IShoesService {
    List<Shoes> getAll();
    List<Shoes> getAllWithColor();
}
