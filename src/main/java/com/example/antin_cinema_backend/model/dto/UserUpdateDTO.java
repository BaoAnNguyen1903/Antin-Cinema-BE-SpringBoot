package com.example.antin_cinema_backend.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserUpdateDTO {
    private int uid;
    private String name;
    private Date dob;
    private String gender;
    private String phone;
    private String email;
    private String username;
    private Integer points;
}
