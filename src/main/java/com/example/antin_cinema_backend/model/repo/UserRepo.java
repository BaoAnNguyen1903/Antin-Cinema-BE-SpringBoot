package com.example.antin_cinema_backend.model.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.antin_cinema_backend.model.entity.User;

public class UserRepo {
    public ArrayList<User> getAllUsers() throws Exception {
        ArrayList<User> UserList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from users");
        while (rs.next()) {
            int uid = rs.getInt("uid");
            String name = rs.getString("name");
            Date dob = rs.getDate("dob");
            String gender = rs.getString("gender");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String avatar = rs.getString("avatar");
            int points = rs.getInt("points");
            int status = rs.getInt("status");
            String role = rs.getString("role");
            User user = new User(uid, name, dob, gender, phone, email, username, password, avatar, points, status,
                    role);
            UserList.add(user);
        }
        return UserList;
    }

    public User getUserById(int uid) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from users where uid = ?");
        ps.setInt(1, uid);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int uid1 = rs.getInt("uid");
        String name = rs.getString("name");
        Date dob = rs.getDate("dob");
        String gender = rs.getString("gender");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String avatar = rs.getString("avatar");
        int points = rs.getInt("points");
        int status = rs.getInt("status");
        String role = rs.getString("role");
        User user = new User(uid1, name, dob, gender, phone, email, username, password, avatar, points, status, role);
        return user;
    }

    public void addNewUser(User user) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into users(name, dob, gender, phone, email, username, password, avatar, points, status, role) values(?,?,?,?,?,? ?,?,?,?,?)");
        ps.setString(1, user.getName());
        ps.setDate(2, user.getDob());
        ps.setString(3, user.getGender());
        ps.setString(4, user.getPhone());
        ps.setString(5, user.getEmail());
        ps.setString(6, user.getUsername());
        ps.setString(7, user.getPassword());
        ps.setString(8, user.getAvatar());
        ps.setInt(9, user.getPoints());
        ps.setInt(10, user.getStatus());
        ps.setString(11, user.getRole());
        ps.executeUpdate();
        ps.close();
    }

    public void updateUserById(User user) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "update users set name = ?, dob = ?, gender = ?, phone = ?, email = ?, username = ?, password = ?, avatar = ?, points = ?, status = ? , role = ? where uid = ?");
        ps.setString(1, user.getName());
        ps.setDate(2, user.getDob());
        ps.setString(3, user.getGender());
        ps.setString(4, user.getPhone());
        ps.setString(5, user.getEmail());
        ps.setString(6, user.getUsername());
        ps.setString(7, user.getPassword());
        ps.setString(8, user.getAvatar());
        ps.setInt(9, user.getPoints());
        ps.setInt(10, user.getStatus());
        ps.setString(11, user.getRole());
        ps.setInt(12, user.getUid());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public boolean checkPassword(int uid, String oldPassword) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("SELECT password FROM users WHERE uid = ?");
        ps.setInt(1, uid);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String existingPassword = rs.getString("password");
            return existingPassword.equals(oldPassword);
        }
        rs.close();
        ps.close();
        return false;
    }

    public boolean existsByUsername(String username) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("SELECT 1 FROM users WHERE username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        rs.close();
        ps.close();
        con.close();
        return exists;
    }

    public boolean isValidPhone(String phone) {
        // Định dạng số điện thoại Việt Nam
        String phoneNumberPattern = "^(\\+84|0)\\d{9,10}$";
        Pattern pattern = Pattern.compile(phoneNumberPattern);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    public boolean existsByEmail(String email) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("SELECT 1 FROM users WHERE email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        rs.close();
        ps.close();
        con.close();
        return exists;
    }

    public boolean existsByPhone(String phone) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("SELECT 1 FROM users WHERE phone = ?");
        ps.setString(1, phone);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        rs.close();
        ps.close();
        con.close();
        return exists;
    }
}
