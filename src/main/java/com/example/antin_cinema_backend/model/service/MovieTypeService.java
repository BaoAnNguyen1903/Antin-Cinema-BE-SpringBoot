package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.MovieType;
import com.example.antin_cinema_backend.model.repo.MovieTypeRepo;

@Service
public class MovieTypeService {
    @Autowired
    private MovieTypeRepo movieTypeRepo;

    public ArrayList<MovieType> getAllMovieTypes() throws Exception {
        return movieTypeRepo.getAllMovieTypes();
    }

    public MovieType getMovieTypeById(int mtid) throws Exception {
        return movieTypeRepo.getMovieTypeById(mtid);
    }

    public MovieType createMovieType(MovieType movieType) throws Exception {
        movieTypeRepo.createMovieType(movieType);
        return movieType;
    }
}
