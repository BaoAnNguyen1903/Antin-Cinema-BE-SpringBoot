package com.example.antin_cinema_backend.model.repo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.Statement;

import com.example.antin_cinema_backend.model.entity.SeatType;

@Repository
public class SeatTypeRepo {
    public ArrayList<SeatType> getAllSeatTypes() throws Exception {
        ArrayList<SeatType> SeatTypeList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from seat_type");
        while (rs.next()) {
            int stid = rs.getInt("stid");
            String seatTypeName = rs.getString("seat_type_name");
            SeatType seatType = new SeatType(stid, seatTypeName);
            SeatTypeList.add(seatType);
        }
        return SeatTypeList;
    }

    public SeatType getSeatTypeById(int stid) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from seat_type where stid = ?");
        ps.setInt(1, stid);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int stid1 = rs.getInt("stid");
        String seatTypeName = rs.getString("seat_type_name");
        SeatType seatType = new SeatType(stid1, seatTypeName);
        return seatType;
    }

    public void createSeatType(SeatType seatType) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into seat_type(seat_type_name) values(?)");
        ps.setString(1, seatType.getSeatTypeName());
        ps.executeUpdate();
        ps.close();
    }

    public void updateSeatTypeById(SeatType seatType) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "update seat_type set seat_type_name = ? where stid = ?");
        ps.setString(1, seatType.getSeatTypeName());
        ps.setInt(2, seatType.getStid());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
