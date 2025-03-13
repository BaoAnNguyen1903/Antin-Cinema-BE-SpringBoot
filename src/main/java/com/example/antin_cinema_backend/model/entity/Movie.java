package com.example.antin_cinema_backend.model.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    private int mid;
    private String movie_name;
    private String movie_description;
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
