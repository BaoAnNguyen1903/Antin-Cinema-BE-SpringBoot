package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.antin_cinema_backend.model.dto.UserUpdateDTO;
import com.example.antin_cinema_backend.model.entity.Movie;
import com.example.antin_cinema_backend.model.entity.User;
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

    public boolean updateMovie(Movie dto) throws Exception {
        Movie existingMovie = movieRepo.getMovieById(dto.getMid());
        if (existingMovie == null) {
            return false;
        }

        // Cập nhật các thuộc tính nếu chúng khác null
        if (dto.getMovieName() != null)
            existingMovie.setMovieName(dto.getMovieName());
        if (dto.getMovieDescription() != null)
            existingMovie.setMovieDescription(dto.getMovieDescription());
        if (dto.getMovieDirector() != null)
            existingMovie.setMovieDirector(dto.getMovieDirector());
        if (dto.getMovieActor() != null)
            existingMovie.setMovieActor(dto.getMovieActor());
        if (dto.getMovieType() != null)
            existingMovie.setMovieType(dto.getMovieType());
        if (dto.getMovieTime() != null)
            existingMovie.setMovieTime(dto.getMovieTime());
        if (dto.getMovieLanguage() != null)
            existingMovie.setMovieLanguage(dto.getMovieLanguage());
        if (dto.getMovieRated() != null)
            existingMovie.setMovieRated(dto.getMovieRated());
        if (dto.getPoster() != null)
            existingMovie.setPoster(dto.getPoster());
        if (dto.getBanner() != null)
            existingMovie.setBanner(dto.getBanner());
        if (dto.getOpenday() != null)
            existingMovie.setOpenday(dto.getOpenday());
        if (dto.getCloseday() != null)
            existingMovie.setCloseday(dto.getCloseday());
        if (dto.getMovieStatus() != 0)
            existingMovie.setMovieStatus(dto.getMovieStatus());

        movieRepo.updateMovieById(existingMovie);
        return true;
    }
}
