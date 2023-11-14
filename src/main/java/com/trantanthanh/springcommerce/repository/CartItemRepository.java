package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByCustomerId(Long id);
    CartItem findByCustomerIdAndShoesVariationId(Long customerId, Long shoesVariation);
}
