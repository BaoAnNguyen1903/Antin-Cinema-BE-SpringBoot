package com.example.antin_cinema_backend.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.antin_cinema_backend.model.entity.Khach;

@Repository
public class KhachRepo {
    public ArrayList<Khach> getAllKhachs() throws Exception {
        ArrayList<Khach> KhachList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from khach");
        while (rs.next()) {
            int kid = rs.getInt("kid");
            String fullName = rs.getString("fullname");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            Khach khach = new Khach(kid, fullName, phone, email);
            KhachList.add(khach);
        }
        return KhachList;
    }

    public Khach getKhachById(int kid) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from khach where kid = ?");
        ps.setInt(1, kid);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int kid1 = rs.getInt("kid");
        String fullName = rs.getString("fullname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        Khach khach = new Khach(kid1, fullName, phone, email);
        return khach;
    }

    public void addNewKhach(Khach khach) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into khach(fullname, phone, email) values(?,?,?)");
        ps.setString(1, khach.getFullName());
        ps.setString(4, khach.getPhone());
        ps.setString(5, khach.getEmail());
        ps.executeUpdate();
        ps.close();
    }
}
