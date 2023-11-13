package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.ShoesColor;
import com.trantanthanh.springcommerce.model.ShoesVariation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoesColorRepository extends JpaRepository<ShoesColor, Long> {

}
