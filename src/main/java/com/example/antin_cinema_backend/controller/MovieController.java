package com.example.antin_cinema_backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.antin_cinema_backend.model.entity.Meta;
import com.example.antin_cinema_backend.model.entity.Movie;
import com.example.antin_cinema_backend.model.entity.PaginateData;
import com.example.antin_cinema_backend.model.service.MovieService;
import com.example.antin_cinema_backend.model.service.PaginatedResult;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/ViewAllMovieList")
    public ResponseEntity<Map<String, Object>> getAllMovies(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "5") int pageSize) throws Exception {

        PaginatedResult<Movie> paginatedResult = movieService.getMoviesPaginated(current, pageSize);
        int total = paginatedResult.getTotal();
        int pages = (int) Math.ceil((double) total / pageSize);

        Meta meta = new Meta(current, pageSize, pages, total);
        PaginateData<Movie> paginatedData = new PaginateData<>(meta, paginatedResult.getResult());

        Map<String, Object> response = new HashMap<>();
        response.put("data", paginatedData);

        return new ResponseEntity<>(response, HttpStatus.OK);
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
