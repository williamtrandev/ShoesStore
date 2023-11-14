package com.trantanthanh.springcommerce.api;

import com.trantanthanh.springcommerce.dto.CustomerDTO;
import com.trantanthanh.springcommerce.model.Customer;
import com.trantanthanh.springcommerce.service.impl.CustomerService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerAPI {
    private final CustomerService customerService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomerDTO customerDTO, HttpSession session) {
        Customer customer = customerService.getOne(customerDTO.getPhone());
        if(customer != null) {
            // Lưu customer id vào session
            session.setAttribute("customerId", customer.getId());
            boolean checkPass = bCryptPasswordEncoder
                    .matches(customerDTO.getPassword(),
                    customer.getPassword());
            if(checkPass) {
                return ResponseEntity.ok(customer);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid phone number or password");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.getOne(customerDTO.getPhone());
        if(customer == null) {
            Customer newCustomer = new Customer();
            newCustomer.setPhone(customerDTO.getPhone());
            newCustomer.setName(customerDTO.getName());
            newCustomer.setAddress(customerDTO.getAddress());
            newCustomer.setPassword(bCryptPasswordEncoder.encode(customerDTO.getPassword()));
            customerService.save(newCustomer);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Phone is used");
    }
}
