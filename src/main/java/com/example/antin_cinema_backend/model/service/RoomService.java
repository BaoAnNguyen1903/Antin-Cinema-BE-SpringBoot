package com.example.antin_cinema_backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.Room;
import com.example.antin_cinema_backend.model.repo.RoomRepo;

@Service
public class RoomService {
    @Autowired
    private RoomRepo roomRepo;

    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    public Room getRoomById(int rid) {
        return roomRepo.findById(rid).orElse(null);
    }

    public Room createRoom(Room room) {
        return roomRepo.save(room);
    }

    public void deleteRoom(int rid) {
        roomRepo.deleteById(rid);
    }
}
