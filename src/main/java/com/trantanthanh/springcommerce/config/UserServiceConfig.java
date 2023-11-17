package com.trantanthanh.springcommerce.config;


import com.trantanthanh.springcommerce.model.User;
import com.trantanthanh.springcommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceConfig implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByPhone(username);

        if(user == null){
            throw new UsernameNotFoundException("Could not find email");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        System.out.println(user.getRole());
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        UserDetails customUserDetail = new UserDetails();
        customUserDetail.setUser(user);
        customUserDetail.setAuthorities(authorities);

        return customUserDetail;
    }
}
