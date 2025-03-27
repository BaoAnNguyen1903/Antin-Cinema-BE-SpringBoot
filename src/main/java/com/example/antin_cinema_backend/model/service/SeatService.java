package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.Seat;
import com.example.antin_cinema_backend.model.repo.SeatRepo;

@Service
public class SeatService {
    @Autowired
    private SeatRepo seatRepo;

    public ArrayList<Seat> getAllSeats() throws Exception {
        return seatRepo.getAllSeats();
    }

    public Seat getSeatById(int sid) throws Exception {
        return seatRepo.getSeatById(sid);
    }

    public Seat createSeat(Seat seat) throws Exception {
        seatRepo.createSeat(seat);
        return seat;
    }
}
