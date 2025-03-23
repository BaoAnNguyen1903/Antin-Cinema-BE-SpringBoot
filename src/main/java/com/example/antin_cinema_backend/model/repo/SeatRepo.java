package com.example.antin_cinema_backend.model.repo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.antin_cinema_backend.model.entity.Room;
import com.example.antin_cinema_backend.model.entity.Seat;
import com.example.antin_cinema_backend.model.entity.SeatType;

@Repository
public class SeatRepo {
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private SeatTypeRepo seatTypeRepo;

    public ArrayList<Seat> getAllSeats() throws Exception {
        ArrayList<Seat> SeatList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from seat");
        while (rs.next()) {
            int sid = rs.getInt("uid");
            int rid = rs.getInt("rid");
            Room room = roomRepo.getRoomById(rid);
            String seatLocation = rs.getString("seat_location");
            int stid = rs.getInt("stid");
            SeatType seatType = seatTypeRepo.getSeatTypeById(stid);
            float seatPrice = rs.getFloat("seat_price");
            Seat seat = new Seat(sid, room, seatLocation, seatType, seatPrice);
            SeatList.add(seat);
        }
        return SeatList;
    }

    public Seat getSeatById(int sid) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from seat where sid = ?");
        ps.setInt(1, sid);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int sid1 = rs.getInt("sid");
        int rid = rs.getInt("rid");
        Room room = roomRepo.getRoomById(rid);
        String seatLocation = rs.getString("seat_location");
        int stid = rs.getInt("stid");
        SeatType seatType = seatTypeRepo.getSeatTypeById(stid);
        float seatPrice = rs.getFloat("seat_price");
        Seat seat = new Seat(sid1, room, seatLocation, seatType, seatPrice);
        return seat;
    }

    public void createSeat(Seat seat) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into seat(rid, seat_location, stid, seat_price) values(?,?,?,?)");
        ps.setInt(1, seat.getRoom().getRid());
        ps.setString(2, seat.getSeatLocation());
        ps.setInt(3, seat.getSeatType().getStid());
        ps.setFloat(4, seat.getSeatPrice());
        ps.executeUpdate();
        ps.close();
    }

    public void updateSeatById(Seat seat) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "update seat set rid = ?, seat_location = ?, stid = ?, seat_price = ? where sid = ?");
        ps.setInt(1, seat.getRoom().getRid());
        ps.setString(2, seat.getSeatLocation());
        ps.setInt(3, seat.getSeatType().getStid());
        ps.setFloat(4, seat.getSeatPrice());
        ps.setInt(5, seat.getSid());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
