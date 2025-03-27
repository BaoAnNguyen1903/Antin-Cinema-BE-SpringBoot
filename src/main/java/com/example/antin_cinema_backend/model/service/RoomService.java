package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.Room;
import com.example.antin_cinema_backend.model.repo.RoomRepo;

@Service
public class RoomService {
    @Autowired
    private RoomRepo roomRepo;

    public ArrayList<Room> getAllRooms() throws Exception {
        return roomRepo.getAllRooms();
    }

    public Room getRoomById(int rid) throws Exception {
        return roomRepo.getRoomById(rid);
    }

    public Room createRoom(Room room) throws Exception {
        roomRepo.createRoom(room);
        return room;
    }
}
