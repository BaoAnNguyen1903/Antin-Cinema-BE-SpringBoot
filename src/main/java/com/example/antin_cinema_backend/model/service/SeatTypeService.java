package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.SeatType;
import com.example.antin_cinema_backend.model.repo.SeatTypeRepo;

@Service
public class SeatTypeService {
    @Autowired
    private SeatTypeRepo seatTypeRepo;

    public ArrayList<SeatType> getAllSeatTypes() throws Exception {
        return seatTypeRepo.getAllSeatTypes();
    }

    public SeatType getSeatTypeById(int stid) throws Exception {
        return seatTypeRepo.getSeatTypeById(stid);
    }

    public SeatType createSeatType(SeatType seatType) throws Exception {
        seatTypeRepo.createSeatType(seatType);
        return seatType;
    }
}
