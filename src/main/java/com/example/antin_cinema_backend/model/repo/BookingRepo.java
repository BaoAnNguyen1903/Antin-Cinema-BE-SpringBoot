package com.example.antin_cinema_backend.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
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

    public Booking getBookingById(int bid) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from booking where bid = ?");
        ps.setInt(1, bid);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int bid1 = rs.getInt("bid");
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
        Booking booking = new Booking(bid1, user, movieShowtime, seat, discount, createDate, totalPrice, status);
        return booking;
    }

    public void createBooking(Booking booking) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into booking(uid, msid, sid, discount_id, create_date, total_price, status) values(?,?,?,?,?,?,?)");
        ps.setInt(1, booking.getUser().getUid());
        ps.setInt(2, booking.getMovieShowtime().getMsid());
        ps.setInt(3, booking.getSeat().getSid());
        ps.setInt(4, booking.getDiscount().getDiscountId());
        ps.setTimestamp(5, Timestamp.valueOf(booking.getCreateDate()));
        ps.executeUpdate();
        ps.close();
    }
}
