package com.trantanthanh.springcommerce.controller;


import com.trantanthanh.springcommerce.model.*;
import com.trantanthanh.springcommerce.service.impl.*;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final OrderService orderService;
    private final UserService customerService;
    private final ShoesService shoesService;
    private final BrandService brandService;
    private final CategoryService categoryService;
    private final ColorService colorService;
    private final SizeService sizeService;

    @GetMapping("/login")
    public String login(HttpSession session, Principal principal) {
        if(principal == null) {
            return "admin_login";
        }
        return "redirect:/admin";
    }


    @GetMapping({"", "/"})
    public String index(Model model, Principal principal) {
        if(principal == null) {
            return "admin_login";
        }
        model.addAttribute("title", "Đơn mới");
        model.addAttribute("activeOrderNew", true);
        List<Order> orderList = orderService.getOrderWithStatus("Đang xử lý");
        model.addAttribute("orderList", orderList);
        return "orders";
    }

    @GetMapping("/old")
    public String old(Model model) {
        model.addAttribute("title", "Đơn đã hoàn thành");
        model.addAttribute("activeOrderOld", true);
        List<Order> orderList = orderService.getOrderWithStatus("Hoàn thành");
        model.addAttribute("orderList", orderList);
        return "orders";
    }

    @GetMapping("/shoes")
    public String shoes(Model model) {
        model.addAttribute("title", "Giày");
        model.addAttribute("activeShoes", true);
        List<Shoes> shoesList = shoesService.getAll();
        model.addAttribute("shoesList", shoesList);
        List<Brand> brandList = brandService.getAll();
        model.addAttribute("brandList", brandList);
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        List<Color> colorList = colorService.getAll();
        for(Color color : colorList) {
            color.setShoesColorList(null);
        }
        model.addAttribute("colorList", colorList);

        List<Size> sizeList = sizeService.getAll();
        for(Size size : sizeList) {
            size.setShoesVariationList(null);
        }
        model.addAttribute("sizeList", sizeList);
        return "admin_shoes";
    }

    @GetMapping("/customers")
    public String customer(Model model) {
        model.addAttribute("title", "Khách hàng");
        model.addAttribute("activeCustomer", true);
        List<User> customerList = customerService.getAll();
        model.addAttribute("customerList", customerList);
        return "customers";
    }
}
