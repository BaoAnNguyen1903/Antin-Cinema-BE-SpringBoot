package com.example.antin_cinema_backend.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.example.antin_cinema_backend.model.entity.MovieType;

@Repository
public class MovieTypeRepo {
    public ArrayList<MovieType> getAllMovieTypes() throws Exception {
        ArrayList<MovieType> MovieTypeList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from movie_type");
        while (rs.next()) {
            int mtid = rs.getInt("mtid");
            String movieTypeName = rs.getString("movie_type_name");
            MovieType movieType = new MovieType(mtid, movieTypeName);
            MovieTypeList.add(movieType);
        }
        return MovieTypeList;
    }

    public MovieType getMovieTypeById(int mtid) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from movie_type where mtid = ?");
        ps.setInt(1, mtid);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int mtid1 = rs.getInt("mtid");
        String movieTypeName = rs.getString("movie_type_name");
        MovieType movieType = new MovieType(mtid1, movieTypeName);
        return movieType;
    }

    public void createMovieType(MovieType movieType) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into movie_type(movie_type_name) values(?)");
        ps.setString(1, movieType.getMovieTypeName());
        ps.executeUpdate();
        ps.close();
    }

    public void updateMovieTypeById(MovieType movieType) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "update movie_type set movie_type_name = ? where mtid = ?");
        ps.setString(1, movieType.getMovieTypeName());
        ps.setInt(2, movieType.getMtid());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
