package com.example.antin_cinema_backend.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.antin_cinema_backend.model.dto.UserUpdateDTO;
import com.example.antin_cinema_backend.model.entity.Meta;
import com.example.antin_cinema_backend.model.entity.Movie;
import com.example.antin_cinema_backend.model.entity.MovieLanguage;
import com.example.antin_cinema_backend.model.entity.MovieRated;
import com.example.antin_cinema_backend.model.entity.MovieType;
import com.example.antin_cinema_backend.model.entity.PaginateData;
import com.example.antin_cinema_backend.model.service.MovieService;
import com.example.antin_cinema_backend.model.service.PaginatedResult;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/ViewAllMovieList")
    public ResponseEntity<Map<String, Object>> getAllMovies(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "5") int pageSize) throws Exception {

        PaginatedResult<Movie> paginatedResult = movieService.getMoviesPaginated(current, pageSize);
        int total = paginatedResult.getTotal();
        int pages = (int) Math.ceil((double) total / pageSize);

        Meta meta = new Meta(current, pageSize, pages, total);
        PaginateData<Movie> paginatedData = new PaginateData<>(meta, paginatedResult.getResult());

        Map<String, Object> response = new HashMap<>();
        response.put("data", paginatedData);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/ViewMovieById/{uid}")
    public ResponseEntity<String> getMovieById(@PathVariable int mid) throws Exception {
        Movie movie = movieService.getMovieById(mid);
        if (movie == null) {
            return new ResponseEntity<>("{\"message\": \"Movie not found\"}", HttpStatus.NOT_FOUND);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(movie);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @PostMapping("/CreateMovie")
    public ResponseEntity<Map<String, Object>> createMovie(@RequestBody Map<String, Object> requestBody) {
        try {
            // Create a new Movie object to be populated
            Movie movie = new Movie();

            // Set mandatory fields from the requestBody
            movie.setMovieName((String) requestBody.get("movieName"));
            movie.setMovieTime((String) requestBody.get("movieTime"));
            movie.setMovieStatus((Integer) requestBody.get("movieStatus"));

            // Set optional fields (only if provided, else set them to null)
            if (requestBody.get("movieDescription") != null) {
                movie.setMovieDescription((String) requestBody.get("movieDescription"));
            } else {
                movie.setMovieDescription(null); // explicitly set to null
            }

            if (requestBody.get("movieDirector") != null) {
                movie.setMovieDirector((String) requestBody.get("movieDirector"));
            } else {
                movie.setMovieDirector(null); // explicitly set to null
            }

            if (requestBody.get("movieActor") != null) {
                movie.setMovieActor((String) requestBody.get("movieActor"));
            } else {
                movie.setMovieActor(null); // explicitly set to null
            }

            if (requestBody.get("poster") != null) {
                movie.setPoster((String) requestBody.get("poster"));
            } else {
                movie.setPoster(null); // explicitly set to null
            }

            if (requestBody.get("banner") != null) {
                movie.setBanner((String) requestBody.get("banner"));
            } else {
                movie.setBanner(null); // explicitly set to null
            }

            // Parse the open and close dates
            String openDayStr = (String) requestBody.get("openday");
            String closeDayStr = (String) requestBody.get("closeday");
            if (openDayStr != null && closeDayStr != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
                movie.setOpenday(LocalDate.parse(openDayStr, formatter));
                movie.setCloseday(LocalDate.parse(closeDayStr, formatter));
            } else {
                movie.setOpenday(null);
                movie.setCloseday(null);
            }

            // Handle the child objects (movieType, movieLanguage, movieRated)
            Map<String, Object> movieTypeObj = (Map<String, Object>) requestBody.get("movieType");
            if (movieTypeObj != null) {
                MovieType movieType = new MovieType();
                movieType.setMtid((Integer) movieTypeObj.get("mtid"));
                movie.setMovieType(movieType);
            } else {
                movie.setMovieType(null); // explicitly set to null
            }

            Map<String, Object> movieLanguageObj = (Map<String, Object>) requestBody.get("movieLanguage");
            if (movieLanguageObj != null) {
                MovieLanguage movieLanguage = new MovieLanguage();
                movieLanguage.setMlid((Integer) movieLanguageObj.get("mlid"));
                movie.setMovieLanguage(movieLanguage);
            } else {
                movie.setMovieLanguage(null); // explicitly set to null
            }

            Map<String, Object> movieRatedObj = (Map<String, Object>) requestBody.get("movieRated");
            if (movieRatedObj != null) {
                MovieRated movieRated = new MovieRated();
                movieRated.setMrid((Integer) movieRatedObj.get("mrid"));
                movie.setMovieRated(movieRated);
            } else {
                movie.setMovieRated(null); // explicitly set to null
            }

            // Save the movie to the database via the service
            Movie newMovie = movieService.createMovie(movie);

            if (newMovie == null) {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("error", "Movie creation failed");
                return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("data", newMovie);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace(); // For debugging
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal server error");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/UpdateMovie")
    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody UserUpdateDTO userDTO) throws Exception {
        boolean updated = movieService.updateUser(userDTO);
        if (updated) {
            Map<String, Object> response = Map.of(
                    "data", true,
                    "message", "Movie updated successfully");
            return ResponseEntity.ok(response);
        } else {
            Map<String, Object> response = Map.of(
                    "data", false,
                    "message", "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
