package com.trantanthanh.springcommerce.api;

import com.trantanthanh.springcommerce.dto.CartItemDTO;
import com.trantanthanh.springcommerce.dto.CustomerDTO;
import com.trantanthanh.springcommerce.model.CartItem;
import com.trantanthanh.springcommerce.model.Customer;
import com.trantanthanh.springcommerce.model.ShoesVariation;
import com.trantanthanh.springcommerce.service.impl.CartItemService;
import com.trantanthanh.springcommerce.service.impl.CustomerService;
import com.trantanthanh.springcommerce.service.impl.ShoesService;
import com.trantanthanh.springcommerce.service.impl.ShoesVariationService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartAPI {
    private final CartItemService cartItemService;
    private final CustomerService customerService;
    private final ShoesVariationService shoesVariationService;

    @GetMapping("/{id}")
    public List<CartItem> getCart(@PathVariable("id") Long id) {
        return cartItemService.getAllByCustomerId(id);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<?> addToCart(@RequestBody CartItemDTO cartItemDTO, HttpSession session) {
        Long customerId = (Long) session.getAttribute("customerId");
        Long shoesVariationId = cartItemDTO.getShoesVariationId();
        CartItem existCartItem = cartItemService.getOneByCustomerIdAndShoesVariationId(customerId, shoesVariationId);
        int quantity = cartItemDTO.getQuantity();
        double price = cartItemDTO.getPrice();
        if(existCartItem == null) {
            ShoesVariation shoesVariation = shoesVariationService.getById(shoesVariationId);
            Customer customer = customerService.getById(customerId);
            CartItem cartItem = new CartItem();
            cartItem.setCustomer(customer);
            cartItem.setQuantity(quantity);
            cartItem.setPrice(price);
            cartItem.setShoesVariation(shoesVariation);
            return ResponseEntity.status(HttpStatus.CREATED).body(cartItemService.save(cartItem));
        } else {
            existCartItem.setQuantity(existCartItem.getQuantity() + quantity);
            return ResponseEntity.status(HttpStatus.CREATED).body(cartItemService.save(existCartItem));
        }
    }
}
