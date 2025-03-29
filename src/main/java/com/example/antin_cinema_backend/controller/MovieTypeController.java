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
import com.example.antin_cinema_backend.model.entity.MovieType;
import com.example.antin_cinema_backend.model.service.MovieTypeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/movieType")
public class MovieTypeController {
    @Autowired
    private MovieTypeService movieTypeService;

    @GetMapping("/ViewAllMovieTypeList")
    public ResponseEntity<String> getAllMovieTypes() throws Exception {
        List<MovieType> movieTypes = movieTypeService.getAllMovieTypes();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(movieTypes);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @GetMapping("/ViewMovieTypeById/{mtid}")
    public ResponseEntity<String> getMovieTypeById(@PathVariable int mtid) throws Exception {
        MovieType movieType = movieTypeService.getMovieTypeById(mtid);
        if (movieType == null) {
            return new ResponseEntity<>("{\"message\": \"Movie Type not found\"}", HttpStatus.NOT_FOUND);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(movieType);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @PostMapping("/CreateMovieType")
    public ResponseEntity<String> createMovieType(@RequestBody MovieType movieType) throws Exception {
        MovieType newMovieType = movieTypeService.createMovieType(movieType);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(newMovieType);
        return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
    }
}
