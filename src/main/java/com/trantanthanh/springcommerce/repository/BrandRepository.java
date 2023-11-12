package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
