package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
