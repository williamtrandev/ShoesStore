package com.trantanthanh.springcommerce.controller;

import com.trantanthanh.springcommerce.model.CartItem;
import com.trantanthanh.springcommerce.repository.CartItemRepository;
import com.trantanthanh.springcommerce.service.impl.CartItemService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartItemService cartItemService;
    @GetMapping({"", "/"})
    public String index(Model model, HttpSession session) {
        model.addAttribute("title", "Giỏ hàng");
        Object id = session.getAttribute("customerId");
        List<CartItem> cartItemList = cartItemService.getAllByCustomerId((Long) id);
        model.addAttribute("cartItemList", cartItemList);
        return "cart";
    }
}
