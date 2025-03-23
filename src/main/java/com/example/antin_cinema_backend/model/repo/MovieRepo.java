package com.example.antin_cinema_backend.model.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.antin_cinema_backend.model.entity.Movie;
import com.example.antin_cinema_backend.model.entity.MovieType;
import com.example.antin_cinema_backend.model.entity.User;

@Repository
public class MovieRepo {
    @Autowired
    private MovieTypeRepo movieTypeRepo;
    public ArrayList<Movie> getAllMovies() throws Exception {
        ArrayList<Movie> MovieList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from movie");
        while (rs.next()) {
            int mid = rs.getInt("mid");
            String movieName = rs.getString("movie_name");
            String movieDescription = rs.getString("movie_description");
            String movieDirector = rs.getString("movie_director");
            String movieActor = rs.getString("movie_actor");
            int mtid = rs.getInt("mtid");
            MovieType movieType = movieTypeRepo.getMovieTypeById(mtid);
            String movieTime = rs.getString("movie_time");

            UserList.add(user);
        }
        return MovieList;
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

    public void createUser(User user) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into users(name, dob, gender, phone, email, username, password, avatar, points, status, role) values(?,?,?,?,?,?,?,?,?,?,?)");
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
}
