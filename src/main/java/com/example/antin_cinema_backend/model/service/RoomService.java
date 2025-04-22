package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.Room;
import com.example.antin_cinema_backend.model.repo.RoomRepo;

@Service
public class RoomService {
    @Autowired
    private RoomRepo roomRepo;

    public PaginatedResult<Room> getRoomsPaginated(int current, int pageSize) throws Exception {
        List<Room> allRooms = roomRepo.getAllRooms();
        int total = allRooms.size();

        int fromIndex = Math.max((current - 1) * pageSize, 0);
        int toIndex = Math.min(fromIndex + pageSize, total);

        List<Room> paginatedList = new ArrayList<>();
        if (fromIndex < toIndex) {
            paginatedList = allRooms.subList(fromIndex, toIndex);
        }

        return new PaginatedResult<>(paginatedList, total);
    }

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
