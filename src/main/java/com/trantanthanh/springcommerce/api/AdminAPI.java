package com.trantanthanh.springcommerce.api;

import com.trantanthanh.springcommerce.api.requestDTO.AdminRequest;
import com.trantanthanh.springcommerce.model.User;
import com.trantanthanh.springcommerce.service.impl.UserService;
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
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AdminRequest adminRequest, HttpSession session) {
        User admin = userService.getOne(adminRequest.getUsername());
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
