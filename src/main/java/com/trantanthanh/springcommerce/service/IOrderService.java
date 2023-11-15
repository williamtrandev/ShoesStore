package com.trantanthanh.springcommerce.service;

import com.trantanthanh.springcommerce.dto.CartItemDTO;
import com.trantanthanh.springcommerce.dto.OrderDTO;
import com.trantanthanh.springcommerce.dto.OrderLineDTO;
import com.trantanthanh.springcommerce.model.CartItem;
import com.trantanthanh.springcommerce.model.Order;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> getAll();
    boolean save(Long customerId);
    List<OrderDTO> getAllByCustomerId(Long id);
    List<Order> getAllOrderByCustomerId(Long id);

    List<OrderLineDTO> getOrderLineByOrderId(Long id);

    OrderDTO updateStatus(Long id);
}
