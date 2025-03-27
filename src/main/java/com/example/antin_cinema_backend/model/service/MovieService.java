package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.Movie;
import com.example.antin_cinema_backend.model.repo.MovieRepo;

@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRepo;

    public ArrayList<Movie> getAllMovies() throws Exception {
        return movieRepo.getAllMovies();
    }

    public Movie getMovieById(int mid) throws Exception {
        return movieRepo.getMovieById(mid);
    }

    public Movie createMovie(Movie movie) throws Exception {
        movieRepo.createMovie(movie);
        return movie;
    }
}
