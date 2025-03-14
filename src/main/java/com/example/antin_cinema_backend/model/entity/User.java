package com.example.antin_cinema_backend.model.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @Column(length = 64)
    private String name;

    @Column(name = "dob")
    private Date dob;

    @Column(length = 1)
    private String gender;

    @Column(length = 16, unique = true)
    private String phone;

    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 64, unique = true)
    private String username;

    @Column(length = 128)
    private String password;

    @Column(columnDefinition = "TEXT")
    private String avatar;

    @Column(name = "points")
    private int points;

    @Column(name = "status")
    private int status;

    @Column(length = 1)
    private String role;
}
