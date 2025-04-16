package com.example.antin_cinema_backend.controller;

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

import com.example.antin_cinema_backend.model.entity.Meta;
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

        Meta meta = new Meta(current, pageSize, pages, total);
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
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody Map<String, String> requestBody) {
        User user = new User();
        user.setName(requestBody.get("name"));
        user.setUsername(requestBody.get("username"));
        user.setPassword(requestBody.get("password"));
        user.setEmail(requestBody.get("email"));

        // Set default values
        user.setDob(null);
        user.setGender(null);
        user.setPhone(null);
        user.setAvatar(null);
        user.setPoints(0);
        user.setStatus(0);
        user.setRole("U");

        try {
            User newUser = userService.createUser(user);

            if (newUser == null) {
                // Username hoặc Email đã tồn tại
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("error", "Username or Email already exists");
                return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT); // 409
            }

            // Trả về user vừa tạo trong object "data"
            Map<String, Object> response = new HashMap<>();
            response.put("data", newUser);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            // Lỗi hệ thống
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal server error");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/UpdateUser")
    public ResponseEntity<String> updateUser(@RequestBody User user) throws Exception {
        boolean updated = userService.updateUser(user);
        if (updated) {
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update failed");
        }
    }

    @GetMapping
    public ResponseEntity<?> getUsers(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        return ResponseEntity.ok(userService.getUsers(current, pageSize, name, email));
    }
}
