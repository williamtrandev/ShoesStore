package com.trantanthanh.springcommerce.repository;

import com.trantanthanh.springcommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhone(String phone);

    boolean existsByPhone(String phone);
}
