package com.trantanthanh.springcommerce.controller;

import com.trantanthanh.springcommerce.dto.OrderDTO;
import com.trantanthanh.springcommerce.model.Order;
import com.trantanthanh.springcommerce.service.impl.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final OrderService orderService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/orders")
    public String orders(Model model, HttpServletRequest request) {
        model.addAttribute("title", "Đơn đặt hàng");
        Long id = null;
        model.addAttribute("activeOrder", true);

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userid")) {
                id = Long.valueOf(cookie.getValue());
            }
        }
        List<Order> orderList = orderService.getAllOrderByCustomerId(id);
        model.addAttribute("orderList", orderList);
        return "customer_orders";
    }


}
