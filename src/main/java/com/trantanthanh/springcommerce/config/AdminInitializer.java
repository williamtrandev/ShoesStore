package com.trantanthanh.springcommerce.config;

import com.trantanthanh.springcommerce.model.Admin;
import com.trantanthanh.springcommerce.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void run(String... args) {
        // Tạo một tài khoản admin nếu chưa tồn tại
        if (!adminRepository.existsByUsername("admin")) {
            Admin admin = new Admin();
            admin.setUsername("admin");
            admin.setPassword(bCryptPasswordEncoder.encode("admin"));

            adminRepository.save(admin);
        }
    }
}
