package com.example.antin_cinema_backend.model.entity;

import java.sql.Date;

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
    private Date openday;
    private Date closeday;
    private int movieStatus;
}
