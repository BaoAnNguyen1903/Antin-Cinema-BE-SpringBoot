package com.example.antin_cinema_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.antin_cinema_backend.model.entity.MovieLanguage;
import com.example.antin_cinema_backend.model.service.MovieLanguageService;

@RestController
@RequestMapping("/api/v1/movieLanguage")
public class MovieLanguageController {
    @Autowired
    private MovieLanguageService movieLanguageService;

    @GetMapping("/ViewAllMovieLanguagesList")
    public List<MovieLanguage> getAllMovieLanguages() {
        return movieLanguageService.getAllMovieLanguages();
    }

    @GetMapping("/ViewMovieLanguageById/{id}")
    public MovieLanguage getMovieLanguageById(@PathVariable int id) {
        return movieLanguageService.getMovieLanguageById(id);
    }

    @PostMapping("/CreateNewMovieLanguage")
    public MovieLanguage createMovieLanguage(@RequestBody MovieLanguage movieLanguage) {
        return movieLanguageService.createMovieLanguage(movieLanguage);
    }

    @DeleteMapping("/DeleteMovieLanguage/{id}")
    public void DeleteMovieLanguage(@PathVariable int id) {
        movieLanguageService.deleteMovieLanguage(id);
    }
}
