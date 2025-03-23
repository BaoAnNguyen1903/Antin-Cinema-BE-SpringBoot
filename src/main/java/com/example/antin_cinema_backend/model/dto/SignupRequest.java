package com.example.antin_cinema_backend.model.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String name;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;
    private String role;
}
