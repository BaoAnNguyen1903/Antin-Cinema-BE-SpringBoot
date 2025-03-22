// package com.example.antin_cinema_backend.model.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.example.antin_cinema_backend.model.entity.MovieLanguage;
// import com.example.antin_cinema_backend.model.repo.MovieLanguageRepo;

// @Service
// public class MovieLanguageService {
// @Autowired
// private MovieLanguageRepo movieLanguageRepo;

// public List<MovieLanguage> getAllMovieLanguages() {
// return movieLanguageRepo.findAll();
// }

// public MovieLanguage getMovieLanguageById(int mlid) {
// return movieLanguageRepo.findById(mlid).orElse(null);
// }

// public MovieLanguage createMovieLanguage(MovieLanguage movieLanguage) {
// return movieLanguageRepo.save(movieLanguage);
// }

// public void deleteMovieLanguage(int mlid) {
// movieLanguageRepo.deleteById(mlid);
// }
// }
