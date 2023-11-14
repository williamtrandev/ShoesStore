package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.dto.CartItemDTO;
import com.trantanthanh.springcommerce.model.CartItem;
import com.trantanthanh.springcommerce.repository.CartItemRepository;
import com.trantanthanh.springcommerce.service.ICartItemService;
import com.trantanthanh.springcommerce.utils.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService implements ICartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItemDTO save(CartItem cartItem) {
        return Mapping.convertToCartItemDTO(cartItemRepository.save(cartItem));
    }

    @Override
    public List<CartItem> getAllByCustomerId(Long id) {
        return cartItemRepository.findAllByCustomerId(id);
    }

    @Override
    public CartItem getOneByCustomerIdAndShoesVariationId(Long customerId, Long shoesVariationId) {
        return cartItemRepository.findByCustomerIdAndShoesVariationId(customerId, shoesVariationId);
    }
}
