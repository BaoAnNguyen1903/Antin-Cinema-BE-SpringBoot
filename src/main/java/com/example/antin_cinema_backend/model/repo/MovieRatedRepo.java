package com.example.antin_cinema_backend.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.example.antin_cinema_backend.model.entity.MovieRated;

@Repository
public class MovieRatedRepo {
    public ArrayList<MovieRated> getAllMovieRated() throws Exception {
        ArrayList<MovieRated> MovieRatedList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from movie_rated");
        while (rs.next()) {
            int mrid = rs.getInt("mrid");
            String movieRatedName = rs.getString("movie_rated_name");
            MovieRated movieRated = new MovieRated(mrid, movieRatedName);
            MovieRatedList.add(movieRated);
        }
        return MovieRatedList;
    }

    public MovieRated getMovieRatedById(int mrid) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from movie_rated where mrid = ?");
        ps.setInt(1, mrid);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int mrid1 = rs.getInt("mrid");
        String movieRatedName = rs.getString("movie_rated_name");
        MovieRated movieRated = new MovieRated(mrid1, movieRatedName);
        return movieRated;
    }

    public void createMovieRated(MovieRated movieRated) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into movie_rated(movie_rated_name) values(?)");
        ps.setString(1, movieRated.getMovieRatedName());
        ps.executeUpdate();
        ps.close();
    }

    public void updateMovieRatedById(MovieRated movieRated) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "update movie_rated set movie_rated_name = ? where mrid = ?");
        ps.setString(1, movieRated.getMovieRatedName());
        ps.setInt(2, movieRated.getMrid());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
