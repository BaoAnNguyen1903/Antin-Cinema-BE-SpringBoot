// package com.example.antin_cinema_backend.model.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.antin_cinema_backend.model.entity.Movie;
// import com.example.antin_cinema_backend.model.repo.MovieRepo;

// @Service
// public class MovieService {
// @Autowired
// private MovieRepo movieRepo;

// public List<Movie> getAllMovies() {
// return movieRepo.findAll();
// }

// public Movie getMovieById(int mid) {
// return movieRepo.findById(mid).orElse(null);
// }

// public Movie createMovie(Movie movie) {
// return movieRepo.save(movie);
// }

// public void deleteMovie(int mid) {
// movieRepo.deleteById(mid);
// }
// }
