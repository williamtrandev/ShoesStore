package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Long>, JpaSpecificationExecutor<Shoes> {
    @Query("SELECT DISTINCT s FROM Shoes s " +
            "LEFT JOIN FETCH s.shoesColorList sc " +
            "LEFT JOIN FETCH sc.color " +
            "ORDER BY sc.id ASC")
    List<Shoes> findAllShoesWithColors();

    @Query("SELECT DISTINCT s FROM Shoes s " +
            "LEFT JOIN FETCH s.shoesColorList sc " +
            "LEFT JOIN FETCH sc.color " +
            "WHERE s.id = :id " +
            "ORDER BY sc.id ASC ")
    Shoes findOneWithColors(Long id);


    // API
    List<Shoes> findByNameContainingIgnoreCase(String name);


}
