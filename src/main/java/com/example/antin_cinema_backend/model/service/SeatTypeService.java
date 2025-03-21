package com.example.antin_cinema_backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.antin_cinema_backend.model.entity.SeatType;
import com.example.antin_cinema_backend.model.repo.SeatTypeRepo;

@Service
public class SeatTypeService {
    @Autowired
    private SeatTypeRepo seatTypeRepo;

    public List<SeatType> getAllSeatTypes() {
        return seatTypeRepo.findAll();
    }

    public SeatType getSeatTypeById(int stid) {
        return seatTypeRepo.findById(stid).orElse(null);
    }

    public SeatType createSeatType(SeatType seatType) {
        return seatTypeRepo.save(seatType);
    }

    public void deleteSeatType(int stid) {
        seatTypeRepo.deleteById(stid);
    }
}
