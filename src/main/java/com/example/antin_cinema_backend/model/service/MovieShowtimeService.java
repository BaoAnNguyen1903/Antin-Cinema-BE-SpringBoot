package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.MovieShowtime;
import com.example.antin_cinema_backend.model.repo.MovieShowtimeRepo;

@Service
public class MovieShowtimeService {
    @Autowired
    private MovieShowtimeRepo movieShowtimeRepo;

    public ArrayList<MovieShowtime> getAllMovieShowtimes() throws Exception {
        return movieShowtimeRepo.getAllMovieShowtimes();
    }

    public MovieShowtime getMovieShowtimeById(int msid) throws Exception {
        return movieShowtimeRepo.getMovieShowtimeById(msid);
    }

    public MovieShowtime createMovieShowtime(MovieShowtime movieShowtime) throws Exception {
        movieShowtimeRepo.createMovieShowtime(movieShowtime);
        return movieShowtime;
    }
}
