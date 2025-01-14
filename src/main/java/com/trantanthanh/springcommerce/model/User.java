package com.trantanthanh.springcommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    private String address;

    private String name;

    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orderList;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CartItem> cartItemList;

    private String role;

}
