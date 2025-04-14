package com.example.antin_cinema_backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.antin_cinema_backend.model.entity.Paginate;
import com.example.antin_cinema_backend.model.entity.PaginateData;
import com.example.antin_cinema_backend.model.entity.User;
import com.example.antin_cinema_backend.model.service.PaginatedResult;
import com.example.antin_cinema_backend.model.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/ViewAllUsersList")
    public ResponseEntity<Map<String, Object>> getAllUsers(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "5") int pageSize) throws Exception {

        PaginatedResult<User> paginatedResult = userService.getUsersPaginated(current, pageSize);
        int total = paginatedResult.getTotal();
        int pages = (int) Math.ceil((double) total / pageSize);

        Paginate meta = new Paginate(current, pageSize, pages, total);
        PaginateData<User> paginatedData = new PaginateData<>(meta, paginatedResult.getResult());

        Map<String, Object> response = new HashMap<>();
        response.put("data", paginatedData);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/ViewUserById/{uid}")
    public ResponseEntity<String> getUserById(@PathVariable int uid) throws Exception {
        User user = userService.getUserById(uid);
        if (user == null) {
            return new ResponseEntity<>("{\"message\": \"User not found\"}", HttpStatus.NOT_FOUND);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(user);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @PostMapping("/CreateUser")
    public ResponseEntity<String> createUser(@RequestBody User user) throws Exception {
        User newUser = userService.createUser(user);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(newUser);
        return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
    }
}
