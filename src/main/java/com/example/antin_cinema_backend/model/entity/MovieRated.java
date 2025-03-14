package com.example.antin_cinema_backend.model.entity;

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
@ToString
@Getter
@Setter
@Entity
@Table(name = "movie_rated")
public class MovieRated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mrid;

    @Column(length = 100)
    private String movie_rated_name;
}
