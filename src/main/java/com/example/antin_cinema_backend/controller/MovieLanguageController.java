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
import com.example.antin_cinema_backend.model.entity.MovieLanguage;
import com.example.antin_cinema_backend.model.service.MovieLanguageService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/movieLanguage")
public class MovieLanguageController {
    @Autowired
    private MovieLanguageService movieLanguageService;

    @GetMapping("/ViewAllMovieLanguagesList")
    public ResponseEntity<String> getAllMovieLanguages() throws Exception {
        List<MovieLanguage> movieLanguages = movieLanguageService.getAllMovieLanguages();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(movieLanguages);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @GetMapping("/ViewMovieLanguageById/{mlid}")
    public ResponseEntity<String> getMovieLanguageById(@PathVariable int mlid) throws Exception {
        MovieLanguage movieLanguage = movieLanguageService.getMovieLanguageById(mlid);
        if (movieLanguage == null) {
            return new ResponseEntity<>("{\"message\": \"Movie Language not found\"}", HttpStatus.NOT_FOUND);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(movieLanguage);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @PostMapping("/CreateMovieLanguage")
    public ResponseEntity<String> createMovieLanguage(@RequestBody MovieLanguage movieLanguage) throws Exception {
        MovieLanguage newMovieLanguage = movieLanguageService.createMovieLanguage(movieLanguage);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(newMovieLanguage);
        return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
    }
}
