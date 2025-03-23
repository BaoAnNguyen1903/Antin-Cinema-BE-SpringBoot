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
import com.example.antin_cinema_backend.model.entity.Movie;
import com.example.antin_cinema_backend.model.entity.MovieShowtime;
import com.example.antin_cinema_backend.model.entity.Room;

@Repository
public class MovieShowtimeRepo {
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private RoomRepo roomRepo;

    public ArrayList<MovieShowtime> getAllMovieShowtimes() throws Exception {
        ArrayList<MovieShowtime> MovieShowtimeList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from movie_showtime");
        while (rs.next()) {
            int msid = rs.getInt("msid");
            int mid = rs.getInt("mid");
            Movie movie = movieRepo.getMovieById(mid);
            int rid = rs.getInt("rid");
            Room room = roomRepo.getRoomById(rid);
            LocalDateTime startTime = rs.getTimestamp("start_time").toLocalDateTime();
            LocalDateTime endTime = rs.getTimestamp("end_time").toLocalDateTime();
            MovieShowtime movieShowtime = new MovieShowtime(msid, movie, room, startTime, endTime);
            MovieShowtimeList.add(movieShowtime);
        }
        return MovieShowtimeList;
    }

    public MovieShowtime getMovieShowtimeById(int msid) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from movie_showtime where msid = ?");
        ps.setInt(1, msid);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int msid1 = rs.getInt("msid");
        int mid = rs.getInt("mid");
        Movie movie = movieRepo.getMovieById(mid);
        int rid = rs.getInt("rid");
        Room room = roomRepo.getRoomById(rid);
        LocalDateTime startTime = rs.getTimestamp("start_time").toLocalDateTime();
        LocalDateTime endTime = rs.getTimestamp("end_time").toLocalDateTime();
        MovieShowtime movieShowtime = new MovieShowtime(msid1, movie, room, startTime, endTime);
        return movieShowtime;
    }

    public void createMovieShowtime(MovieShowtime movieShowtime) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into movie_showtime(mid, rid, start_time, end_time) values(?,?,?,?)");
        ps.setInt(1, movieShowtime.getMovie().getMid());
        ps.setInt(2, movieShowtime.getRoom().getRid());
        ps.setTimestamp(3, Timestamp.valueOf(movieShowtime.getStartTime()));
        ps.setTimestamp(4, Timestamp.valueOf(movieShowtime.getEndTime()));
        ps.executeUpdate();
        ps.close();
    }

    public void updateMovieShowtimeById(MovieShowtime movieShowtime) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "update movie_showtime set mid = ?, rid = ?, start_time = ?, end_time = ? where msid = ?");
        ps.setInt(1, movieShowtime.getMovie().getMid());
        ps.setInt(2, movieShowtime.getRoom().getRid());
        ps.setTimestamp(3, Timestamp.valueOf(movieShowtime.getStartTime()));
        ps.setTimestamp(4, Timestamp.valueOf(movieShowtime.getEndTime()));
        ps.setInt(5, movieShowtime.getMsid());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
