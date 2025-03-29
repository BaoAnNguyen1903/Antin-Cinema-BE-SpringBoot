package com.example.antin_cinema_backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.antin_cinema_backend.model.entity.MovieShowtime;
import com.example.antin_cinema_backend.model.service.MovieShowtimeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/movieShowtime")
public class MovieShowtimeController {
    @Autowired
    private MovieShowtimeService movieShowtimeService;

    @GetMapping("/ViewAllMovieShowtimesList")
    public ResponseEntity<String> getAllMovieShowtimes() throws Exception {
        List<MovieShowtime> users = movieShowtimeService.getAllMovieShowtimes();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(users);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @GetMapping("/ViewMovieShowtimeById/{msid}")
    public ResponseEntity<String> getMovieShowtimeById(@PathVariable int msid) throws Exception {
        MovieShowtime movieShowtime = movieShowtimeService.getMovieShowtimeById(msid);
        if (movieShowtime == null) {
            return new ResponseEntity<>("{\"message\": \"Movie Showtime not found\"}", HttpStatus.NOT_FOUND);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(movieShowtime);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @PostMapping("/CreateMovieShowtime")
    public ResponseEntity<String> createMovieShowtime(@RequestBody MovieShowtime movieShowtime) throws Exception {
        MovieShowtime nMovieShowtime = movieShowtimeService.createMovieShowtime(movieShowtime);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(nMovieShowtime);
        return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
    }
}
