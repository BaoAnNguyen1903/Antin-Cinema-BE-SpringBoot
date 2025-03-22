// package com.example.antin_cinema_backend.model.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.example.antin_cinema_backend.model.entity.MovieShowtime;
// import com.example.antin_cinema_backend.model.repo.MovieShowtimeRepo;

// @Service
// public class MovieShowtimeService {
// @Autowired
// private MovieShowtimeRepo movieShowtimeRepo;

// public List<MovieShowtime> getAllMovieShowtimes() {
// return movieShowtimeRepo.findAll();
// }

// public MovieShowtime getMovieShowtimeById(int msid) {
// return movieShowtimeRepo.findById(msid).orElse(null);
// }

// public MovieShowtime createMovieShowtime(MovieShowtime movieShowtime) {
// return movieShowtimeRepo.save(movieShowtime);
// }

// public void deleteMovieShowtime(int msid) {
// movieShowtimeRepo.deleteById(msid);
// }
// }
