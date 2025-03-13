package com.example.antin_cinema_backend.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "movie_showtime")
public class MovieShowtime {
    @Id
    private int msid;
    private Movie movie;
    private Room room;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
}
