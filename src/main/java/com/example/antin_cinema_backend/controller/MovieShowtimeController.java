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
// import com.example.antin_cinema_backend.model.entity.MovieShowtime;
// import com.example.antin_cinema_backend.model.service.MovieShowtimeService;

// @RestController
// @RequestMapping("/api/v1/movieShowtime")
// public class MovieShowtimeController {
// @Autowired
// private MovieShowtimeService movieShowtimeService;

// @GetMapping("/ViewAllMovieShowtimesList")
// public List<MovieShowtime> getAllMovieShowtimes() {
// return movieShowtimeService.getAllMovieShowtimes();
// }

// @GetMapping("/ViewMovieShowtimeById/{id}")
// public MovieShowtime getMovieShowtimeById(@PathVariable int id) {
// return movieShowtimeService.getMovieShowtimeById(id);
// }

// @PostMapping("/CreateNewMovieShowtime")
// public MovieShowtime createMovieShowtime(@RequestBody MovieShowtime
// movieShowtime) {
// return movieShowtimeService.createMovieShowtime(movieShowtime);
// }

// @DeleteMapping("/DeleteMovieShowtime/{id}")
// public void deleteMovieShowtime(@PathVariable int id) {
// movieShowtimeService.deleteMovieShowtime(id);
// }
// }
