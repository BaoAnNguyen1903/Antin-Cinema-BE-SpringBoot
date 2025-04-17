package com.example.antin_cinema_backend.model.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {
    private int mid;
    private String movieName;
    private String movieDescription;
    private String movieDirector;
    private String movieActor;
    private MovieType movieType;
    private String movieTime;
    private MovieLanguage movieLanguage;
    private MovieRated movieRated;
    private String poster;  
    private String banner;
    private LocalDate openday;
    private LocalDate closeday;
    private int movieStatus;
}
