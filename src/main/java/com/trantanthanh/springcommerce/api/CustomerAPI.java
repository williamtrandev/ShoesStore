package com.trantanthanh.springcommerce.api;

import com.trantanthanh.springcommerce.dto.CustomerDTO;
import com.trantanthanh.springcommerce.model.User;
import com.trantanthanh.springcommerce.service.impl.UserService;
import com.trantanthanh.springcommerce.utils.Mapping;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerAPI {
    private final UserService customerService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomerDTO customerDTO, HttpSession session) {
        User customer = customerService.getOne(customerDTO.getPhone());
        if (customer != null && bCryptPasswordEncoder.matches(customerDTO.getPassword(), customer.getPassword())) {

            CustomerDTO returnCustomer = Mapping.convertToCustomerDTO(customer);
            return ResponseEntity.ok(returnCustomer);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid phone number or password");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CustomerDTO customerDTO) {
        User customer = customerService.getOne(customerDTO.getPhone());
        if(customer == null) {
            User newCustomer = new User();
            newCustomer.setPhone(customerDTO.getPhone());
            newCustomer.setName(customerDTO.getName());
            newCustomer.setAddress(customerDTO.getAddress());
            newCustomer.setPassword(bCryptPasswordEncoder.encode(customerDTO.getPassword()));
            newCustomer.setRole("CUSTOMER");
            customerService.save(newCustomer);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Phone is used");
    }
}
