package com.example.antin_cinema_backend.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.antin_cinema_backend.model.entity.Khach;

@Repository
public interface KhachRepo extends JpaRepository<Khach, Integer> {

}
