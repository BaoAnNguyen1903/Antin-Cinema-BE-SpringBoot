package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.Movie;
import com.example.antin_cinema_backend.model.repo.MovieRepo;

@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRepo;

    public PaginatedResult<Movie> getMoviesPaginated(int current, int pageSize) throws Exception {
        List<Movie> allMovies = movieRepo.getAllMovies(); // Lấy danh sách tất cả movie
        int total = allMovies.size();

        int fromIndex = Math.max((current - 1) * pageSize, 0);
        int toIndex = Math.min(fromIndex + pageSize, total);

        List<Movie> paginatedList = new ArrayList<>();
        if (fromIndex < toIndex) {
            paginatedList = allMovies.subList(fromIndex, toIndex);
        }

        return new PaginatedResult<>(paginatedList, total);
    }

    public ArrayList<Movie> getAllMovies() throws Exception {
        return movieRepo.getAllMovies();
    }

    public Movie getMovieById(int mid) throws Exception {
        return movieRepo.getMovieById(mid);
    }

    public Movie createMovie(Movie movie) throws Exception {
        movieRepo.createMovie(movie);
        return movie;
    }
}
