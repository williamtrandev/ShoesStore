package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> getAllByOrderId(Long id);
}
