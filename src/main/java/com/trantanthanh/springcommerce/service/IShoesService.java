package com.trantanthanh.springcommerce.service;

import com.trantanthanh.springcommerce.api.requestDTO.ShoesRequest;
import com.trantanthanh.springcommerce.dto.ShoesDTO;
import com.trantanthanh.springcommerce.model.Shoes;

import java.util.List;

public interface IShoesService {
    List<Shoes> getAll();
    List<Shoes> getAllWithColor();
    Shoes getOne(Long id);

    List<Shoes> searchByName(String name);

    List<Shoes> filter(double minPrice, double maxPrice, List<Long> brandIds, List<Long> colorIds);

    Shoes insertOne(ShoesRequest request);
}
