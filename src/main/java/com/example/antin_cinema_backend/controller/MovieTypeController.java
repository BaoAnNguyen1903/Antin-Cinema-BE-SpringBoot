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
import com.example.antin_cinema_backend.model.entity.MovieType;
import com.example.antin_cinema_backend.model.service.MovieTypeService;

@RestController
@RequestMapping("/api/v1/movieType")
public class MovieTypeController {
    @Autowired
    private MovieTypeService movieTypeService;

    @GetMapping("/ViewAllMovieTypesList")
    public List<MovieType> getAllMovieTypes() {
        return movieTypeService.getAllMovieTypes();
    }

    @GetMapping("/ViewMovieTypeById/{id}")
    public MovieType getMovieTypeById(@PathVariable int id) {
        return movieTypeService.getMovieTypeById(id);
    }

    @PostMapping("/CreateNewMovieType")
    public MovieType createMovieType(@RequestBody MovieType movieType) {
        return movieTypeService.createMovieType(movieType);
    }

    @DeleteMapping("/DeleteMovieType/{id}")
    public void deleteMovieType(@PathVariable int id) {
        movieTypeService.deleteMovieType(id);
    }
}
