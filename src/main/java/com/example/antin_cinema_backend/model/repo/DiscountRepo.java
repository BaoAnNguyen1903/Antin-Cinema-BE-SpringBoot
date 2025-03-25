package com.example.antin_cinema_backend.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.antin_cinema_backend.model.entity.Discount;
import com.example.antin_cinema_backend.model.entity.Khach;
import com.example.antin_cinema_backend.model.entity.User;

@Repository
public class DiscountRepo {
    @Autowired
    private UserRepo userRepo;

    public ArrayList<Discount> getAllDiscounts() throws Exception {
        ArrayList<Discount> DiscountList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from discount");
        while (rs.next()) {
            int discountId = rs.getInt("discount_id");
            int uid = rs.getInt("uid");
            User user = userRepo.getUserById(uid);
            String discoutCode = rs.getString("discount_code");
            String discoutDescription = rs.getString("discount_description");
            float discountPercentage = rs.getFloat("discount_percentage");
            int totalUse = rs.getInt("total_use");
            LocalDate startDate = rs.getDate("start_date").toLocalDate();
            LocalDate endDate = rs.getDate("end_date").toLocalDate();
            float minAmount = rs.getFloat("min_amount");
            float maxAmount = rs.getFloat("max_amount");
            int status = rs.getInt("status");
            Discount discount = new Discount(discountId, user, discoutCode, discoutDescription, discountPercentage,
                    discountId, totalUse, startDate, endDate, minAmount, maxAmount, status);
            DiscountList.add(discount);
        }
        return DiscountList;
    }

    
}
