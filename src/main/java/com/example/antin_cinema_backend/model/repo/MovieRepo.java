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
import com.example.antin_cinema_backend.model.entity.Movie;
import com.example.antin_cinema_backend.model.entity.MovieLanguage;
import com.example.antin_cinema_backend.model.entity.MovieRated;
import com.example.antin_cinema_backend.model.entity.MovieType;

@Repository
public class MovieRepo {
    @Autowired
    private MovieTypeRepo movieTypeRepo;
    @Autowired
    private MovieLanguageRepo movieLanguageRepo;
    @Autowired
    private MovieRatedRepo movieRatedRepo;

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
            int mlid = rs.getInt("mlid");
            MovieLanguage movieLanguage = movieLanguageRepo.getMovieLanguageById(mlid);
            int mrid = rs.getInt("mrid");
            MovieRated movieRated = movieRatedRepo.getMovieRatedById(mrid);
            String poster = rs.getString("poster");
            String banner = rs.getString("banner");
            LocalDate openday = rs.getDate("openday").toLocalDate();
            LocalDate closeday = rs.getDate("closeday").toLocalDate();
            int movieStatus = rs.getInt("movie_status");
            Movie movie = new Movie(mid, movieName, movieDescription, movieDirector, movieActor, movieType, movieTime,
                    movieLanguage, movieRated, poster, banner, openday, closeday, movieStatus);
            MovieList.add(movie);
        }
        return MovieList;
    }

    public Movie getMovieById(int mid) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement("select * from movie where mid = ?");
        ps.setInt(1, mid);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        rs.next();
        int mid1 = rs.getInt("mid");
        String movieName = rs.getString("movie_name");
        String movieDescription = rs.getString("movie_description");
        String movieDirector = rs.getString("movie_director");
        String movieActor = rs.getString("movie_actor");
        int mtid = rs.getInt("mtid");
        MovieType movieType = movieTypeRepo.getMovieTypeById(mtid);
        String movieTime = rs.getString("movie_time");
        int mlid = rs.getInt("mlid");
        MovieLanguage movieLanguage = movieLanguageRepo.getMovieLanguageById(mlid);
        int mrid = rs.getInt("mrid");
        MovieRated movieRated = movieRatedRepo.getMovieRatedById(mrid);
        String poster = rs.getString("poster");
        String banner = rs.getString("banner");
        LocalDate openday = rs.getDate("openday").toLocalDate();
        LocalDate closeday = rs.getDate("closeday").toLocalDate();
        int movieStatus = rs.getInt("movie_status");
        Movie movie = new Movie(mid1, movieName, movieDescription, movieDirector, movieActor, movieType, movieTime,
                movieLanguage, movieRated, poster, banner, openday, closeday, movieStatus);
        return movie;
    }

    public void createMovie(Movie movie) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "insert into movie(movie_name, movie_description, movie_director, movie_actor, mtid, movie_time, mlid, mrid, poster, banner, openday, closeday, movie_status) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, movie.getMovieName());
        ps.setString(2, movie.getMovieDescription());
        ps.setString(3, movie.getMovieDirector());
        ps.setString(4, movie.getMovieActor());
        ps.setInt(5, movie.getMovieType().getMtid());
        ps.setString(6, movie.getMovieTime());
        ps.setInt(7, movie.getMovieLanguage().getMlid());
        ps.setInt(8, movie.getMovieRated().getMrid());
        ps.setString(9, movie.getPoster());
        ps.setString(10, movie.getBanner());
        ps.setDate(11, java.sql.Date.valueOf(movie.getOpenday()));
        ps.setDate(12, java.sql.Date.valueOf(movie.getCloseday()));
        ps.setInt(13, movie.getMovieStatus());
        ps.executeUpdate();
        ps.close();
    }

    public void updateMovieById(Movie movie) throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "update movie set movie_name = ?, movie_description = ?, movie_director = ?, movie_actor = ?, mtid = ?, movie_time = ?, mlid = ?, mrid = ?, poster = ?, banner = ? , openday = ?, closeday = ?, movie_status = ? where mid = ?");
        ps.setString(1, movie.getMovieName());
        ps.setString(2, movie.getMovieDescription());
        ps.setString(3, movie.getMovieDirector());
        ps.setString(4, movie.getMovieActor());
        ps.setInt(5, movie.getMovieType().getMtid());
        ps.setString(6, movie.getMovieTime());
        ps.setInt(7, movie.getMovieLanguage().getMlid());
        ps.setInt(8, movie.getMovieRated().getMrid());
        ps.setString(9, movie.getPoster());
        ps.setString(10, movie.getBanner());
        ps.setDate(11, java.sql.Date.valueOf(movie.getOpenday()));
        ps.setDate(12, java.sql.Date.valueOf(movie.getCloseday()));
        ps.setInt(13, movie.getMovieStatus());
        ps.setInt(13, movie.getMid());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
