package com.trantanthanh.springcommerce.api;

import com.trantanthanh.springcommerce.dto.CustomerDTO;
import com.trantanthanh.springcommerce.model.Admin;
import com.trantanthanh.springcommerce.model.Customer;
import com.trantanthanh.springcommerce.service.impl.AdminService;
import com.trantanthanh.springcommerce.service.impl.CustomerService;
import com.trantanthanh.springcommerce.utils.Mapping;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminAPI {
    private final AdminService adminService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin adminRequest, HttpSession session) {
        Admin admin = adminService.getOne(adminRequest.getUsername());
        if(admin != null) {
            // Lưu admin id vào session
            session.setAttribute("adminId", admin.getId());
            boolean checkPass = bCryptPasswordEncoder
                    .matches(adminRequest.getPassword(),
                            admin.getPassword());
            if(checkPass) {
                return ResponseEntity.ok(admin);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}
