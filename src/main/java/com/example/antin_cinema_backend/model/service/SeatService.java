package com.example.antin_cinema_backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.antin_cinema_backend.model.entity.Seat;
import com.example.antin_cinema_backend.model.repo.SeatRepo;

@Service
public class SeatService {
    @Autowired
    private SeatRepo seatRepo;

    public List<Seat> getAllSeats() {
        return seatRepo.findAll();
    }

    public Seat getSeatById(int sid) {
        return seatRepo.findById(sid).orElse(null);
    }

    public Seat createSeat(Seat seat) {
        return seatRepo.save(seat);
    }

    public void deleteSeat(int sid) {
        seatRepo.deleteById(sid);
    }
}
