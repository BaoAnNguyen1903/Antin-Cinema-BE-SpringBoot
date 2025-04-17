package com.example.antin_cinema_backend.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.antin_cinema_backend.model.dto.LoginRequest;
import com.example.antin_cinema_backend.model.dto.SignupRequest;
import com.example.antin_cinema_backend.model.entity.User;
import com.example.antin_cinema_backend.model.repo.UserRepo;
import com.example.antin_cinema_backend.model.service.AccountService;
import com.example.antin_cinema_backend.model.service.TokenBlacklistService;
import com.example.antin_cinema_backend.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
        @Autowired
        UserRepo userRepo;

        @Autowired
        JwtUtil jwtUtil;

        @Autowired
        AccountService accountService;

        @Autowired
        private TokenBlacklistService tokenBlacklistService;

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpSession session)
                        throws Exception {
                User user = userRepo.getUserByUsername(request.getUsername());
                String check = request.getUsername() + "  : " + request.getPassword();
                if (user == null || !user.getPassword().equals(request.getPassword())) {
                        return ResponseEntity.badRequest()
                                        .body(Map.of("message",
                                                        check + "data : " + user + "Invalid username or password"));
                }
                String accessToken = jwtUtil.generateToken(user.getUsername());

                session.setAttribute("user", user);
                Map<String, Object> userData = new HashMap<>();
                userData.put("uid", user.getUid());
                userData.put("name", user.getName());
                userData.put("dob", user.getDob());
                userData.put("gender", user.getGender());
                userData.put("phone", user.getPhone());
                userData.put("email", user.getEmail());
                userData.put("avatar", user.getAvatar());
                userData.put("points", user.getPoints());
                userData.put("status", user.getStatus());
                userData.put("role", user.getRole());

                Map<String, Object> data = Map.of(
                                "access_token", accessToken,
                                "user", userData);

                return ResponseEntity.status(HttpStatus.CREATED)
                                .body(Map.of("data", data));
        }

        @GetMapping("/account")
        public ResponseEntity<?> fetchAccount(
                        @RequestHeader(value = "Authorization", required = false) String authHeader) {
                try {
                        // Kiểm tra Authorization Header có hợp lệ không
                        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                                                Map.of(
                                                                "statusCode", 401,
                                                                "message", "Access Token bị thiếu hoặc không hợp lệ.",
                                                                "error", "Unauthorized"));
                        }

                        // Cắt token ra khỏi chuỗi "Bearer "
                        String token = authHeader.replace("Bearer ", "").trim();
                        User user = accountService.getUserFromToken(token);

                        // Nếu không tìm thấy user, token sai hoặc hết hạn
                        if (user == null) {
                                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                                                Map.of(
                                                                "statusCode", 401,
                                                                "message",
                                                                "Access Token hết hạn, không hợp lệ hoặc không tồn tại.",
                                                                "error", "Unauthorized"));
                        }

                        // Tạo Map chứa thông tin user (không giới hạn cặp như Map.of)
                        Map<String, Object> userData = new HashMap<>();
                        userData.put("uid", user.getUid());
                        userData.put("name", user.getName());
                        userData.put("dob", user.getDob());
                        userData.put("gender", user.getGender());
                        userData.put("phone", user.getPhone());
                        userData.put("email", user.getEmail());
                        userData.put("username", user.getUsername());
                        userData.put("avatar", user.getAvatar());
                        userData.put("points", user.getPoints());
                        userData.put("status", user.getStatus());
                        userData.put("role", user.getRole());

                        // Chuẩn hóa response trả về
                        Map<String, Object> response = new HashMap<>();
                        response.put("statusCode", 200);
                        response.put("message", "");
                        response.put("data", Map.of("user", userData));

                        return ResponseEntity.ok(response);

                } catch (Exception e) {
                        e.printStackTrace(); // Hoặc log.error(...) nếu có Logger
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                                        Map.of(
                                                        "statusCode", 401,
                                                        "message", "Có lỗi xảy ra khi xử lý Access Token.",
                                                        "error", "Unauthorized"));
                }
        }

        @PostMapping("/logout")
        public ResponseEntity<?> logout(HttpServletRequest request) {
                String token = extractTokenFromRequest(request);

                if (token != null && !token.isEmpty()) {
                        tokenBlacklistService.blacklistToken(token);
                        Map<String, String> response = new HashMap<>();
                        response.put("data", "ok");
                        return ResponseEntity.ok(response);
                }

                return ResponseEntity.badRequest().body("Token không hợp lệ");
        }

        private String extractTokenFromRequest(HttpServletRequest request) {
                String bearerToken = request.getHeader("Authorization");
                if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
                        return bearerToken.substring(7);
                }
                return null;
        }

        @PostMapping("/register")
        public ResponseEntity<Map<String, Object>> register(@RequestBody SignupRequest request) {
                Map<String, Object> response = new HashMap<>();
                try {
                        if (userRepo.existsByUsername(request.getUsername())) {
                                response.put("error", "Username already exists");
                                return ResponseEntity.badRequest().body(response);
                        }

                        if (userRepo.existsByEmail(request.getEmail())) {
                                response.put("error", "Email already exists");
                                return ResponseEntity.badRequest().body(response);
                        }

                        User newUser = userRepo.registerUser(
                                        request.getName(),
                                        request.getUsername(),
                                        request.getPassword(),
                                        request.getEmail());

                        if (newUser != null) {
                                response.put("data", newUser);
                                return ResponseEntity.ok(response);
                        } else {
                                response.put("error", "User creation failed");
                                return ResponseEntity.status(500).body(response);
                        }

                } catch (Exception e) {
                        response.put("error", "Server error: " + e.getMessage());
                        return ResponseEntity.status(500).body(response);
                }
        }
}
