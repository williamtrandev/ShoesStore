package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.dto.OrderDTO;
import com.trantanthanh.springcommerce.dto.OrderLineDTO;
import com.trantanthanh.springcommerce.model.CartItem;
import com.trantanthanh.springcommerce.model.Customer;
import com.trantanthanh.springcommerce.model.Order;
import com.trantanthanh.springcommerce.model.OrderLine;
import com.trantanthanh.springcommerce.repository.CartItemRepository;
import com.trantanthanh.springcommerce.repository.CustomerRepository;
import com.trantanthanh.springcommerce.repository.OrderLineRepository;
import com.trantanthanh.springcommerce.repository.OrderRepository;
import com.trantanthanh.springcommerce.service.IOrderService;
import com.trantanthanh.springcommerce.utils.Mapping;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService implements IOrderService {
    private final CustomerRepository customerRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;

    @Override
    public List<OrderDTO> getAll() {
        return Mapping.convertToListOrderDTO(orderRepository.findAll());
    }

    @Override
    public boolean save(Long customerId) {
        Customer customer = customerRepository.getReferenceById(customerId);
        if(customer.getId() == null) {
            return false;
        }
        List<CartItem> cartItemList = cartItemRepository.findAllByCustomerId(customerId);
        Order order = new Order();
        Date currentDate = new Date();
        order.setDateOrder(new java.sql.Date(currentDate.getTime()));
        order.setCustomer(customer);
        order.setStatus("Đang xử lý");
        orderRepository.save(order);
        List<OrderLine> orderLineList = new ArrayList<>();
        double total = 0;
        for(CartItem cartItem : cartItemList) {
            OrderLine orderLine = new OrderLine();
            orderLine.setOrder(order);
            orderLine.setPrice(cartItem.getPrice());
            orderLine.setQuantity(cartItem.getQuantity());
            orderLine.setShoesVariation(cartItem.getShoesVariation());
            orderLineList.add(orderLine);
            System.out.println(cartItem.getQuantity() * cartItem.getPrice());
            total += cartItem.getQuantity() * cartItem.getPrice();
            // Xóa khỏi giỏ hàng
            cartItemRepository.deleteById(cartItem.getId());
        }
        orderLineRepository.saveAll(orderLineList);
        order.setOrderLineList(orderLineList);
        order.setTotal(total);
        orderRepository.save(order);
        return true;
    }

    @Override
    public List<OrderDTO> getAllByCustomerId(Long id) {
        return Mapping.convertToListOrderDTO(orderRepository.getAllByCustomerIdOrderByIdDesc(id));
    }

    @Override
    public List<Order> getAllOrderByCustomerId(Long id) {
        return orderRepository.getAllByCustomerIdOrderByIdDesc(id);
    }

    @Override
    public List<OrderLineDTO> getOrderLineByOrderId(Long id) {
        return Mapping.convertToListOrderLineDTO(orderLineRepository.getAllByOrderId(id));
    }

    @Override
    public OrderDTO updateStatus(Long id) {
        Order order = orderRepository.getReferenceById(id);
        String currStatus = order.getStatus();
        String newStatus = currStatus.equals("Đang xử lý") ? "Hoàn thành" : "Đang xử lý";
        order.setStatus(newStatus);
        return Mapping.convertToOrderDTO(orderRepository.save(order));
    }


}
