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

    public Discount getDiscountById(int discountId) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from discount where discount_id = ?");
        ps.setInt(1, discountId);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int discountId1 = rs.getInt("discount_id");
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
        Discount discount = new Discount(discountId1, user, discoutCode, discoutDescription, discountPercentage,
                discountId1, totalUse, startDate, endDate, minAmount, maxAmount, status);
        return discount;
    }

    public void createDiscount(Discount discount) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into discount(uid, discount_code, discount_description, discount_percentage, number_of_discount,total_use,start_date,end_date ,min_amount,max_amount, status) values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, discount.getUser().getUid());
        ps.setString(2, discount.getDiscountCode());
        ps.setString(3, discount.getDiscountDescription());
        ps.setFloat(4, discount.getDiscountPercentage());
        ps.setInt(5, discount.getNumberOfDiscount());
        ps.setInt(6, discount.getTotalUse());
        ps.setDate(7, java.sql.Date.valueOf(discount.getStartDate()));
        ps.setDate(8, java.sql.Date.valueOf(discount.getEndDate()));
        ps.setFloat(9, discount.getMinAmount());
        ps.setFloat(10, discount.getMaxAmount());
        ps.setInt(11, discount.getStatus());
        ps.executeUpdate();
        ps.close();
    }
}
