// package com.example.antin_cinema_backend.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.antin_cinema_backend.model.entity.Room;
// import com.example.antin_cinema_backend.model.service.RoomService;

// @RestController
// @RequestMapping("/api/v1/room")
// public class RoomController {
// @Autowired
// private RoomService romService;

// @GetMapping("/ViewAllRoomsList")
// public List<Room> getAllRooms() {
// return romService.getAllRooms();
// }

// @GetMapping("/ViewRoomById/{id}")
// public Room getRoomById(@PathVariable int id) {
// return romService.getRoomById(id);
// }

// @PostMapping("/CreateNewRoom")
// public Room createRoom(@RequestBody Room room) {
// return romService.createRoom(room);
// }

// @DeleteMapping("/DeleteRoom/{id}")
// public void deleteRoom(@PathVariable int id) {
// romService.deleteRoom(id);
// }
// }
