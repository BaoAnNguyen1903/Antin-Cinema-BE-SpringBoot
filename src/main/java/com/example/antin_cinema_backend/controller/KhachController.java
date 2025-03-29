package com.example.antin_cinema_backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.antin_cinema_backend.model.entity.Khach;
import com.example.antin_cinema_backend.model.service.KhachService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@Controller
@RequestMapping("/api/v1/khach")
public class KhachController {
    @Autowired
    private KhachService khachService;

    @GetMapping("/ViewAllKhachsList")
    public ResponseEntity<String> getAllKhachs() throws Exception {
        List<Khach> khachs = khachService.getAllKhachs();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(khachs);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @GetMapping("/ViewKhachById/{uid}")
    public ResponseEntity<String> getKhachById(@PathVariable int kid) throws Exception {
        Khach khach = khachService.getKhachById(kid);
        if (khach == null) {
            return new ResponseEntity<>("{\"message\": \"Khach not found\"}", HttpStatus.NOT_FOUND);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(khach);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @PostMapping("/CreateKhach")
    public ResponseEntity<String> createKhach(@RequestBody Khach khach) throws Exception {
        Khach newKhach = khachService.createKhach(khach);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(newKhach);
        return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
    }
}
