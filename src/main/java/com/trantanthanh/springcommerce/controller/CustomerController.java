package com.trantanthanh.springcommerce.controller;

import com.trantanthanh.springcommerce.dto.OrderDTO;
import com.trantanthanh.springcommerce.model.Order;
import com.trantanthanh.springcommerce.service.impl.*;
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
    public String orders(Model model, HttpSession session) {
        model.addAttribute("title", "Đơn đặt hàng");
        model.addAttribute("activeOrder", true);
        Long id = (Long) session.getAttribute("customerId");
        List<Order> orderList = orderService.getAllOrderByCustomerId(id);
        model.addAttribute("orderList", orderList);
        return "customer_orders";
    }


}
