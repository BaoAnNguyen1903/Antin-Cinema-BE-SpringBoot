package com.example.antin_cinema_backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.antin_cinema_backend.model.dto.LoginRequest;

import com.example.antin_cinema_backend.model.entity.User;
import com.example.antin_cinema_backend.model.repo.UserRepo;
import com.example.antin_cinema_backend.security.JwtUtil;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
        @Autowired
        UserRepo userRepo;

        @Autowired
        JwtUtil jwtUtil;

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpSession session)
                        throws Exception {
                User user = userRepo.getUserByUsername(request.getUsername());
                String check = request.getUsername() + "  : " + request.getPassword();
                if (user == null || !user.getPassword().equals(request.getPassword())) {
                        return ResponseEntity.badRequest()
                                        .body(Map.of("message",
                                                        check + "data : " + user + "Invalid username or password"));
                }
                String accessToken = jwtUtil.generateToken(user.getUsername());

                session.setAttribute("user", user);
                Map<String, Object> userData = Map.of(
                                "uid", user.getUid(),
                                "name", user.getName(),
                                "dob", user.getDob(),
                                "gender", user.getGender(),
                                "phone", user.getPhone(),
                                "email", user.getEmail(),
                                "avatar", user.getAvatar(),
                                "points", user.getPoints(),
                                "status", user.getStatus(),
                                "role", user.getRole());

                Map<String, Object> data = Map.of(
                                "access_token", accessToken,
                                "user", userData);

                return ResponseEntity.status(HttpStatus.CREATED)
                                .body(Map.of("data", data));
        }
}
