package com.example.antin_cinema_backend.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int msid;

    @ManyToOne
    @JoinColumn(name = "mid", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "rid", nullable = false)
    private Room room;

    @Column(name = "start_time")
    private LocalDateTime start_time;

    @Column(name = "end_time")
    private LocalDateTime end_time;
}
