package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByPhone(String phone);
}
