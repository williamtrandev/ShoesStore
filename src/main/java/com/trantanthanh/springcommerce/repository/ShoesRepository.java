package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Long> {
    @Query("SELECT DISTINCT s FROM Shoes s " +
            "LEFT JOIN FETCH s.shoesColorList sc " +
            "LEFT JOIN FETCH sc.color")
    List<Shoes> findAllShoesWithColors();
}
