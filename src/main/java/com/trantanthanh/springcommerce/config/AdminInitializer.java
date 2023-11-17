package com.trantanthanh.springcommerce.config;

import com.trantanthanh.springcommerce.model.User;
import com.trantanthanh.springcommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final UserRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void run(String... args) {
        // Tạo một tài khoản admin nếu chưa tồn tại
        if (!adminRepository.existsByPhone("admin")) {
            User admin = new User();
            admin.setPhone("admin");
            admin.setPassword(bCryptPasswordEncoder.encode("admin"));
            admin.setRole("ADMIN");
            adminRepository.save(admin);
        }
    }
}
