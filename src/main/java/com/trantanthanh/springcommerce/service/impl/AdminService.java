package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.model.Admin;
import com.trantanthanh.springcommerce.repository.AdminRepository;
import com.trantanthanh.springcommerce.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public Admin getOne(String username) {
        return adminRepository.findAdminByUsername(username);
    }
}
