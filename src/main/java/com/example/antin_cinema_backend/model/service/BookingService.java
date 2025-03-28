package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.Booking;
import com.example.antin_cinema_backend.model.repo.BookingRepo;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;

    public ArrayList<Booking> getAllBookings() throws Exception {
        return bookingRepo.getAllBookings();
    }

    public Booking getBookingById(int bid) throws Exception {
        return bookingRepo.getBookingById(bid);
    }

    public Booking createBooking(Booking booking) throws Exception {
        bookingRepo.createBooking(booking);
        return booking;
    }
}
