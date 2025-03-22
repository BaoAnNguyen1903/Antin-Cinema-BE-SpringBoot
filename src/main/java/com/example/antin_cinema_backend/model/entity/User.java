package com.example.antin_cinema_backend.model.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int uid;
    private String name;
    private Date dob;
    private String gender;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String avatar;
    private int points;
    private int status;
    private String role;
}
