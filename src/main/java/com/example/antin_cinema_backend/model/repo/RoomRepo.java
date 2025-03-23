package com.example.antin_cinema_backend.model.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.antin_cinema_backend.model.entity.Room;
import com.example.antin_cinema_backend.model.entity.User;

@Repository
public class RoomRepo {
    public ArrayList<Room> getAllRooms() throws Exception {
        ArrayList<Room> RoomList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from room");
        while (rs.next()) {
            int rid = rs.getInt("rid");
            int roomName = rs.getInt("room_name");
            Room room = new Room(rid, roomName);
            RoomList.add(room);
        }
        return RoomList;
    }

    public Room getRoomById(int rid) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from room where rid = ?");
        ps.setInt(1, rid);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int rid1 = rs.getInt("rid");
        int roomName = rs.getInt("room_name");
        Room room = new Room(rid1, roomName);
        return room;
    }

    public void createRoom(Room room) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into room(room_name) values(?)");
        ps.setInt(1, room.getRoomName());
        ps.executeUpdate();
        ps.close();
    }

    public void updateRoomById(Room room) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "update room set room_name = ? where rid = ?");
        ps.setInt(1, room.getRoomName());
        ps.setInt(2, room.getRid());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
