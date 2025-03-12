package com.example.antin_cinema_backend.model;

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
    // mid int auto_increment primary key,
    // movie_name varchar(50) unique,
    // movie_description text,
    // movie_director varchar(50),
    // movie_actor varchar(128),
    // mtid int,
    // foreign key (mtid) references movie_type(mtid),
    // movie_time varchar(24),
    // mlid int,
    // foreign key (mlid) references movie_language(mlid),
    // mrid int,
    // foreign key (mrid) references movie_rated(mrid),
    // poster text,
    // banner text,
    // openday date,
    // closeday date,
    // movie_status int
    private int mid;
    private String movie_name;
    private String movie_description;
    private String movie_actor;
    private MovieType movieType;
    private String movie_time;
    private MovieLanguage movieLanguage;
    
}
