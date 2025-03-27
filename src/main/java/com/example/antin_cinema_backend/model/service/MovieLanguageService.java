package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.MovieLanguage;
import com.example.antin_cinema_backend.model.repo.MovieLanguageRepo;

@Service
public class MovieLanguageService {
    @Autowired
    private MovieLanguageRepo movieLanguageRepo;

    public ArrayList<MovieLanguage> getAllMovieLanguages() throws Exception {
        return movieLanguageRepo.getAllMovieLanguages();
    }

    public MovieLanguage getMovieLanguageById(int mlid) throws Exception {
        return movieLanguageRepo.getMovieLanguageById(mlid);
    }

    public MovieLanguage createMovieLanguage(MovieLanguage movieLanguage) throws Exception {
        movieLanguageRepo.createMovieLanguage(movieLanguage);
        return movieLanguage;
    }
}
