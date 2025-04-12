package com.example.antin_cinema_backend.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String authHeader = request.getHeader("Authorization");

        // Kiểm tra Authorization header
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            // Kiểm tra token hợp lệ
            if (jwtUtil.validateToken(token)) {
                // Trích xuất username từ token
                String username = jwtUtil.getUsernameFromToken(token);

                // Gắn username vào request để các controller sử dụng
                request.setAttribute("username", username);
                return true;
            }
        }

        // Nếu không có token hoặc token không hợp lệ
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }
}
