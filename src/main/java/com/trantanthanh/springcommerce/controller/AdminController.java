package com.trantanthanh.springcommerce.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("title", "Đơn đặt hàng");
        model.addAttribute("activeOrder", true);
        return "orders";
    }

    @GetMapping("/shoes")
    public String shoes(Model model) {
        model.addAttribute("title", "Giày");
        model.addAttribute("activeShoes", true);
        return "orders";
    }

    @GetMapping("/customers")
    public String customer(Model model) {
        model.addAttribute("title", "Khách hàng");
        model.addAttribute("activeCustomer", true);
        return "orders";
    }
}
