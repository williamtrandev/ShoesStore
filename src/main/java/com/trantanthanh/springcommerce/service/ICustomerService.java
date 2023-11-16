package com.trantanthanh.springcommerce.service;

import com.trantanthanh.springcommerce.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getOne(String phone);
    Customer getById(Long id);
    Customer save(Customer customer);

    List<Customer> getAll();
}
