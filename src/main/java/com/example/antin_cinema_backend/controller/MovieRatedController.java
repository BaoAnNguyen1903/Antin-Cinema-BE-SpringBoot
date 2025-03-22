// package com.example.antin_cinema_backend.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.antin_cinema_backend.model.entity.MovieRated;
// import com.example.antin_cinema_backend.model.service.MovieRatedService;

// @RestController
// @RequestMapping("/api/v1/movieRated")
// public class MovieRatedController {
// @Autowired
// private MovieRatedService movieRatedService;

// @GetMapping("/ViewAllMovieRatedsList")
// public List<MovieRated> getAllMovieRateds() {
// return movieRatedService.getAllMovieRateds();
// }

// @GetMapping("/ViewMovieRatedById/{id}")
// public MovieRated getMovieRatedById(@PathVariable int id) {
// return movieRatedService.getMovieRatedById(id);
// }

// @PostMapping("/CreateNewMovieRated")
// public MovieRated createMovieRated(@RequestBody MovieRated movieRated) {
// return movieRatedService.createMovieRated(movieRated);
// }

// @DeleteMapping("/DeleteMovieRated/{id}")
// public void deleteMovieRated(@PathVariable int id) {
// movieRatedService.deleteMovieRated(id);
// }
// }
