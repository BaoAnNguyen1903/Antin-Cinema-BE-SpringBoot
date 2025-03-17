package com.example.antin_cinema_backend.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.antin_cinema_backend.model.entity.MovieType;

public interface MovieTypeRepo extends JpaRepository<MovieType, Integer> {

}
