package com.trantanthanh.springcommerce.service.impl;

import com.trantanthanh.springcommerce.model.Customer;
import com.trantanthanh.springcommerce.repository.CustomerRepository;
import com.trantanthanh.springcommerce.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer getOne(String phone) {
        return customerRepository.findByPhone(phone);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getReferenceById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }


}
