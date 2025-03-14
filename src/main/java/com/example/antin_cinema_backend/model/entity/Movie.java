package com.example.antin_cinema_backend.model.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mid;

    @Column(length = 50, unique = true)
    private String movie_name;

    @Column(name = "movie_description")
    private String movie_description;

    @Column(length = 50)
    private String movie_director;

    @Column(length = 128)
    private String movie_actor;

    @OneToMany
    @JoinColumn(name = "movie_type", nullable = false)
    private MovieType movieType;

    @Column(length = 24)
    private String movie_time;

    @OneToMany
    @JoinColumn(name = "movie_language", nullable = false)
    private MovieLanguage movieLanguage;

    @OneToOne
    @JoinColumn(name = "movie_rated", nullable = false)
    private MovieRated movieRated;

    @Column(name = "poster")
    private String poster;

    @Column(name = "banner")
    private String banner;

    @Column(name = "openday")
    private Date openday;

    @Column(name = "closeday")
    private Date closeday;

    @Column(name = "movie_status")
    private int movie_status;
}
