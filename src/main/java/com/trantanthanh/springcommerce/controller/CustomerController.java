package com.trantanthanh.springcommerce.controller;

import com.trantanthanh.springcommerce.service.impl.CustomerService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/login")
    public String login(HttpSession session) {
        Object customerId = session.getAttribute("customerId");
        if(customerId == null) {
            return "login";
        }
        return "redirect:/shoes";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
