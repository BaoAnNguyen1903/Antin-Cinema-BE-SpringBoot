package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.MovieRated;
import com.example.antin_cinema_backend.model.repo.MovieRatedRepo;

@Service
public class MovieRatedService {
    @Autowired
    private MovieRatedRepo movieRatedRepo;

    public ArrayList<MovieRated> getAllMovieRated() throws Exception {
        return movieRatedRepo.getAllMovieRated();
    }

    public MovieRated getMovieRatedById(int mrid) throws Exception {
        return movieRatedRepo.getMovieRatedById(mrid);
    }

    public MovieRated createMovieRated(MovieRated movieRated) throws Exception {
        movieRatedRepo.createMovieRated(movieRated);
        return movieRated;
    }
}
