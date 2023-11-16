package com.trantanthanh.springcommerce.api;

import com.trantanthanh.springcommerce.dto.OrderDTO;
import com.trantanthanh.springcommerce.dto.OrderLineDTO;
import com.trantanthanh.springcommerce.service.impl.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderAPI {
    private final OrderService orderService;

    @GetMapping({"", "/"})
    public List<OrderDTO> getAll() {
        return orderService.getAll();
    }
    @PostMapping("/{customerId}")
    public ResponseEntity<?> save(@PathVariable(name = "customerId") Long id) {
        boolean checkSave = orderService.save(id);
        if(!checkSave) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer is not exist");
        }
        return ResponseEntity.ok("Save order successfully");
    }

    @GetMapping("/{orderId}")
    public List<OrderLineDTO> detail(@PathVariable(name = "orderId") Long id) {
        return orderService.getOrderLineByOrderId(id);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<?> updateStatus(@PathVariable(name = "orderId") Long id) {
        OrderDTO updatedOrder = orderService.updateStatus(id);
        if(updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update status order");
    }

}
