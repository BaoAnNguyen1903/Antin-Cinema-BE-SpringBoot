package com.example.antin_cinema_backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.antin_cinema_backend.model.entity.Room;
import com.example.antin_cinema_backend.model.service.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {
    @Autowired
    private RoomService romService;

    @GetMapping("/ViewAllRoomsList")
    public ResponseEntity<String> getAllRooms() throws Exception {
        List<Room> rooms = romService.getAllRooms();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(rooms);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @GetMapping("/ViewRoomById/{rid}")
    public ResponseEntity<String> getRoomById(@PathVariable int rid) throws Exception {
        Room room = romService.getRoomById(rid);
        if (room == null) {
            return new ResponseEntity<>("{\"message\": \"Room not found\"}", HttpStatus.NOT_FOUND);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(room);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @PostMapping("/CreateRoom")
    public ResponseEntity<String> createRoom(@RequestBody Room room) throws Exception {
        Room newRoom = romService.createRoom(room);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(newRoom);
        return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
    }
}
