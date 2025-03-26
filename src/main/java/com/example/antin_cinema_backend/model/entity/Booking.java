package com.example.antin_cinema_backend.model.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    private int bid;
    private User user;
    private MovieShowtime movieShowtime;
    private Seat seat;
    private Discount discount;
    private LocalDateTime createDate;
    private float totalPrice;
    private int status;
}
