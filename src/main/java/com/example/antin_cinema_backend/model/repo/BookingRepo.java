package com.example.antin_cinema_backend.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.antin_cinema_backend.model.entity.Booking;
import com.example.antin_cinema_backend.model.entity.Discount;
import com.example.antin_cinema_backend.model.entity.Khach;
import com.example.antin_cinema_backend.model.entity.MovieShowtime;
import com.example.antin_cinema_backend.model.entity.Seat;
import com.example.antin_cinema_backend.model.entity.User;

@Repository
public class BookingRepo {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MovieShowtimeRepo movieShowtimeRepo;
    @Autowired
    private SeatRepo seatRepo;
    @Autowired
    private DiscountRepo discountRepo;

    public ArrayList<Booking> getAllBookings() throws Exception {
        ArrayList<Booking> BookingList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from booking");
        while (rs.next()) {
            int bid = rs.getInt("bid");
            int uid = rs.getInt("uid");
            User user = userRepo.getUserById(uid);
            int msid = rs.getInt("msid");
            MovieShowtime movieShowtime = movieShowtimeRepo.getMovieShowtimeById(msid);
            int sid = rs.getInt("sid");
            Seat seat = seatRepo.getSeatById(sid);
            int discountId = rs.getInt("discount_id");
            Discount discount = discountRepo.getDiscountById(discountId);
            LocalDateTime createDate = rs.getTimestamp("create_date").toLocalDateTime();
            float totalPrice = rs.getFloat("total_price");
            int status = rs.getInt("status");
            Booking booking = new Booking(bid, user, movieShowtime, seat, discount, createDate, totalPrice, status);
            BookingList.add(booking);
        }
        return BookingList;
    }
}
