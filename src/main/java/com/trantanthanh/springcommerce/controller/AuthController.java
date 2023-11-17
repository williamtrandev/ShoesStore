package com.trantanthanh.springcommerce.controller;

import com.trantanthanh.springcommerce.config.UserDetails;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class AuthController {

    @GetMapping("/login")
    public String login(HttpSession session, Principal principal) {

        if(principal == null) {
            return "login";
        }
        String role = String.valueOf(((UserDetails) ((Authentication) principal).getPrincipal()).getAuthorities().stream().findFirst());
        if(role.equals("CUSTOMER")) {
            return "redirect:/shoes";
        } else {
            return "redirect:/admin";
        }
    }

}
