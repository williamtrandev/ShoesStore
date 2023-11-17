package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.model.User;
import com.trantanthanh.springcommerce.repository.UserRepository;
import com.trantanthanh.springcommerce.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository customerRepository;
    @Override
    public User getOne(String phone) {
        return customerRepository.findByPhone(phone);
    }

    @Override
    public User getById(Long id) {
        return customerRepository.getReferenceById(id);
    }

    @Override
    public User save(User customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<User> getAll() {
        return customerRepository.findAll();
    }


}
