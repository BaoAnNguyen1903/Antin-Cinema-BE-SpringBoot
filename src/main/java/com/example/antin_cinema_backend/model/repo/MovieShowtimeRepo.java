package com.example.antin_cinema_backend.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.antin_cinema_backend.model.entity.MovieShowtime;

public interface MovieShowtimeRepo extends JpaRepository<MovieShowtime, Integer> {

}
