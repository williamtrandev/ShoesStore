package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByUsername(String username);

    boolean existsByUsername(String username);
}
