package com.trantanthanh.springcommerce.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // Lấy thông tin user từ Authentication object
        UserDetails customerDetails = (UserDetails) authentication.getPrincipal();
        Long userId = customerDetails.getId(); // Giả sử userId lưu trong username

        // Tạo cookie
        Cookie cookie = new Cookie("userid", userId + "");
        cookie.setMaxAge(60 * 60 * 24); // Thời gian sống của cookie (1 ngày)
        cookie.setPath("/");

        // Thêm cookie vào response
        response.addCookie(cookie);

        // Lưu userId vào session
        HttpSession session = request.getSession();
        session.setAttribute("userId", userId);

        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            response.sendRedirect("/admin");
        } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CUSTOMER"))) {
            response.sendRedirect("/shoes");
        }

    }
}
