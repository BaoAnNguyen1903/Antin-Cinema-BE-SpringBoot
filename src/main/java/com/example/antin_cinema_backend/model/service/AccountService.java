package com.example.antin_cinema_backend.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.User;
import com.example.antin_cinema_backend.model.repo.UserRepo;
import com.example.antin_cinema_backend.security.JwtUtil;

@Service
public class AccountService {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserRepo userRepo;

    public User getUserFromToken(String token) throws Exception {
        if (!jwtUtil.validateToken(token)) {
            return null;
        }
        String username = jwtUtil.getUsernameFromToken(token);
        return userRepo.getUserByUsername(username);
    }
}
