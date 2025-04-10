// package com.example.antin_cinema_backend.config;

// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;

// import lombok.Value;

// @Component
// public class JwtTokenProvider {
//     @Value("${jwt.secret}")
//     private String jwtSecret;

//     @Value("${jwt.expirationMs}")
//     private int jwtExpirationMs;

//     public String generateToken(Authentication authentication) {
//         UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
//         Date now = new Date();
//         Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

//         return Jwts.builder()
//                 .setSubject(userPrincipal.getUsername())
//                 .setIssuedAt(now)
//                 .setExpiration(expiryDate)
//                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                 .compact();
//     }
// }
