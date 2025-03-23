package com.example.antin_cinema_backend.model.entity;

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
public class Seat {
    private int sid;
    private Room room;
    private String seatLocation;
    private SeatType seatType;
    private float seatPrice;
}
