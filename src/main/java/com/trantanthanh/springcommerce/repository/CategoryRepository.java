package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
