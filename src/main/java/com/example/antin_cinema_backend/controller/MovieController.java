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
import com.example.antin_cinema_backend.model.entity.Movie;
import com.example.antin_cinema_backend.model.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/ViewAllMoviesList")
    public ResponseEntity<String> getAllMovies() throws Exception {
        List<Movie> movies = movieService.getAllMovies();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(movies);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @GetMapping("/ViewMovieById/{uid}")
    public ResponseEntity<String> getMovieById(@PathVariable int mid) throws Exception {
        Movie movie = movieService.getMovieById(mid);
        if (movie == null) {
            return new ResponseEntity<>("{\"message\": \"Movie not found\"}", HttpStatus.NOT_FOUND);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(movie);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @PostMapping("/CreateMovie")
    public ResponseEntity<String> createUser(@RequestBody Movie movie) throws Exception {
        Movie newMovie = movieService.createMovie(movie);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(newMovie);
        return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
    }
}
