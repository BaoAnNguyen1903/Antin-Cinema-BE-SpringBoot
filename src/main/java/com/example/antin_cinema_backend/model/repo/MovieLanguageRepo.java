package com.example.antin_cinema_backend.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.example.antin_cinema_backend.model.entity.MovieLanguage;

@Repository
public class MovieLanguageRepo {
    public ArrayList<MovieLanguage> getAllMovieLanguages() throws Exception {
        ArrayList<MovieLanguage> MovieLanguageList = new ArrayList<>();
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from movie_language");
        while (rs.next()) {
            int mtid = rs.getInt("mlid");
            String movieLanguageName = rs.getString("movie_language_name");
            MovieLanguage movieLanguage = new MovieLanguage(mtid, movieLanguageName);
            MovieLanguageList.add(movieLanguage);
        }
        return MovieLanguageList;
    }

    public MovieLanguage getMovieLanguageById(int mlid) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from movie_language where mlid = ?");
        ps.setInt(1, mlid);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int mlid1 = rs.getInt("mlid");
        String movieLanguageName = rs.getString("movie_language_name");
        MovieLanguage movieLanguage = new MovieLanguage(mlid1, movieLanguageName);
        return movieLanguage;
    }

    public void createMovieLanguage(MovieLanguage movieLanguage) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into movie_language(movie_language_name) values(?)");
        ps.setString(1, movieLanguage.getMovieLanguageName());
        ps.executeUpdate();
        ps.close();
    }

    public void updateMovieLanguageById(MovieLanguage movieLanguage) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "update movie_language set movie_language_name = ? where mlid = ?");
        ps.setString(1, movieLanguage.getMovieLanguageName());
        ps.setInt(2, movieLanguage.getMlid());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
