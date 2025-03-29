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
import com.example.antin_cinema_backend.model.entity.MovieRated;
import com.example.antin_cinema_backend.model.service.MovieRatedService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/movieRated")
public class MovieRatedController {
    @Autowired
    private MovieRatedService movieRatedService;

    @GetMapping("/ViewAllMovieRatedList")
    public ResponseEntity<String> getAllMovieRated() throws Exception {
        List<MovieRated> movieRateds = movieRatedService.getAllMovieRated();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(movieRateds);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @GetMapping("/ViewMovieRatedById/{mrid}")
    public ResponseEntity<String> getUserById(@PathVariable int mrid) throws Exception {
        MovieRated movieRated = movieRatedService.getMovieRatedById(mrid);
        if (movieRated == null) {
            return new ResponseEntity<>("{\"message\": \"Movie Rated not found\"}", HttpStatus.NOT_FOUND);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(movieRated);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @PostMapping("/CreateMovieRated")
    public ResponseEntity<String> createUser(@RequestBody MovieRated movieRated) throws Exception {
        MovieRated newMovieRated = movieRatedService.createMovieRated(movieRated);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(newMovieRated);
        return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
    }
}
