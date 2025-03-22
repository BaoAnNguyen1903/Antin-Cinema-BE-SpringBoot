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
    private String movie_name;
    private String movie_description;
    private String movie_director;
    private String movie_actor;
    private MovieType movieType;
    private String movie_time;
    private MovieLanguage movieLanguage;
    private MovieRated movieRated;
    private String poster;
    private String banner;
    private Date openday;
    private Date closeday;
    private int movie_status;
}
