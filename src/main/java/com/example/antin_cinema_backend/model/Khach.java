package com.example.antin_cinema_backend.model;

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
public class Khach {
    private int kid;
    private String fullName;
    private String phone;
    private String email;
}
