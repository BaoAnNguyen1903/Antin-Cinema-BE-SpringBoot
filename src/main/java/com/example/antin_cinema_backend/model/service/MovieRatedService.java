package com.example.antin_cinema_backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.MovieRated;
import com.example.antin_cinema_backend.model.repo.MovieRatedRepo;

@Service
public class MovieRatedService {
    @Autowired
    private MovieRatedRepo movieRatedRepo;

    public List<MovieRated> getAllMovieRateds() {
        return movieRatedRepo.findAll();
    }

    public MovieRated getMovieRatedById(int mrid) {
        return movieRatedRepo.findById(mrid).orElse(null);
    }

    public MovieRated createMovieRated(MovieRated movieRated) {
        return movieRatedRepo.save(movieRated);
    }

    public void deleteMovieRated(int mrid) {
        movieRatedRepo.deleteById(mrid);
    }
}
