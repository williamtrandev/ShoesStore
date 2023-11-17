package com.trantanthanh.springcommerce.service;

import com.trantanthanh.springcommerce.model.User;

import java.util.List;

public interface IUserService {
    User getOne(String phone);
    User getById(Long id);
    User save(User customer);

    List<User> getAll();
}
