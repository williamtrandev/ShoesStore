package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getAllByCustomerIdOrderByIdDesc(Long id);

    List<Order> findAllByStatus(String status);
}
