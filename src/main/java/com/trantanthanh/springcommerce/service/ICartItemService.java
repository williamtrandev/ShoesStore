package com.trantanthanh.springcommerce.service;

import com.trantanthanh.springcommerce.dto.CartItemDTO;
import com.trantanthanh.springcommerce.model.CartItem;

import java.util.List;

public interface ICartItemService {
    CartItemDTO save(CartItem cartItem);

    List<CartItem> getAllByCustomerId(Long id);

    CartItem getOneByCustomerIdAndShoesVariationId(Long customerId, Long shoesVariationId);

    CartItem getOne(Long id);

    boolean deleteOne(Long id);
}
