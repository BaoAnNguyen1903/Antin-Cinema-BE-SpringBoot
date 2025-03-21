package com.example.antin_cinema_backend.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.antin_cinema_backend.model.entity.SeatType;

public interface SeatTypeRepo extends JpaRepository<SeatType, Integer> {

}
