package com.trantanthanh.springcommerce.service;

import com.trantanthanh.springcommerce.dto.CartItemDTO;
import com.trantanthanh.springcommerce.dto.OrderDTO;
import com.trantanthanh.springcommerce.model.CartItem;
import com.trantanthanh.springcommerce.model.Order;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> getAll();
    boolean save(Long customerId);
}
