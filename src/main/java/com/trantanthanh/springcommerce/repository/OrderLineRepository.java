package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
