package com.trantanthanh.springcommerce.service;

import com.trantanthanh.springcommerce.model.Admin;

public interface IAdminService {
    Admin getOne(String username);
}
