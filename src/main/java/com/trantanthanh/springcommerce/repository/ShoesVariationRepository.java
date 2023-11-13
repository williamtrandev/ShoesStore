package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.ShoesVariation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoesVariationRepository extends JpaRepository<ShoesVariation, Long> {
    @Query("SELECT DISTINCT sv FROM ShoesVariation sv " +
            "JOIN FETCH sv.size " +
            "WHERE sv.shoesColor.id = :id")

    List<ShoesVariation> findAllWithSize(Long id);
}
