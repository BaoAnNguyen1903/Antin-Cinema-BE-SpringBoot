package com.example.antin_cinema_backend.controller;

import java.util.HashMap;
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

import com.example.antin_cinema_backend.model.entity.Meta;
import com.example.antin_cinema_backend.model.entity.PaginateData;
import com.example.antin_cinema_backend.model.entity.Room;
import com.example.antin_cinema_backend.model.service.PaginatedResult;
import com.example.antin_cinema_backend.model.service.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {
    @Autowired
    private RoomService romService;

    @GetMapping("/ViewAllRooms")
    public ResponseEntity<Map<String, Object>> getAllUsers(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "5") int pageSize) throws Exception {

        PaginatedResult<Room> paginatedResult = romService.getRoomsPaginated(current, pageSize);
        int total = paginatedResult.getTotal();
        int pages = (int) Math.ceil((double) total / pageSize);

        Meta meta = new Meta(current, pageSize, pages, total);
        PaginateData<Room> paginatedData = new PaginateData<>(meta, paginatedResult.getResult());

        Map<String, Object> response = new HashMap<>();
        response.put("data", paginatedData);

        return new ResponseEntity<>(response, HttpStatus.OK);
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
