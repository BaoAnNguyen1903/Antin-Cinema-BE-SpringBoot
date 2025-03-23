package com.example.antin_cinema_backend.model.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieShowtime {
    private int msid;
    private Movie movie;
    private Room room;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
