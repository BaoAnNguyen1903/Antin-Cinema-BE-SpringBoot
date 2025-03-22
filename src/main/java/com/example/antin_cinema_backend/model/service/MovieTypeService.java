// package com.example.antin_cinema_backend.model.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.example.antin_cinema_backend.model.entity.MovieType;
// import com.example.antin_cinema_backend.model.repo.MovieTypeRepo;

// @Service
// public class MovieTypeService {
// @Autowired
// private MovieTypeRepo movieTypeRepo;

// public List<MovieType> getAllMovieTypes() {
// return movieTypeRepo.findAll();
// }

// public MovieType getMovieTypeById(int mtid) {
// return movieTypeRepo.findById(mtid).orElse(null);
// }

// public MovieType createMovieType(MovieType movieType) {
// return movieTypeRepo.save(movieType);
// }

// public void deleteMovieType(int mtid) {
// movieTypeRepo.deleteById(mtid);
// }
// }
