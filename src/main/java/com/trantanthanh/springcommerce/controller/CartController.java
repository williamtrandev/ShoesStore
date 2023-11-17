package com.trantanthanh.springcommerce.controller;

import com.trantanthanh.springcommerce.config.UserDetails;
import com.trantanthanh.springcommerce.model.CartItem;
import com.trantanthanh.springcommerce.service.impl.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartItemService cartItemService;
    @GetMapping({"", "/"})
    public String index(Model model, Principal principal) {
        if(principal == null) {
            return "redirect:/customer/login";
        }
        model.addAttribute("title", "Giỏ hàng");
        UserDetails customerDetails = (UserDetails) ((Authentication) principal).getPrincipal();
        Long id = customerDetails.getId();
        List<CartItem> cartItemList = cartItemService.getAllByCustomerId((Long) id);
        model.addAttribute("cartItemList", cartItemList);
        return "cart";
    }
}
