package com.example.antin_cinema_backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    @OneToOne
    @JoinColumn(name = "room", nullable = false)
    private Room room;

    @Column(length = 16)
    private String seat_location;

    @OneToOne
    @JoinColumn(name = "seat_type", nullable = false)
    private SeatType seatType;

    @Column(name = "seat_price")
    private float seat_price;
}
