// package com.example.antin_cinema_backend.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.antin_cinema_backend.model.entity.Khach;
// import com.example.antin_cinema_backend.model.service.KhachService;

// @RestController
// @Controller
// @RequestMapping("/api/v1/khach")
// public class KhachController {
// @Autowired
// private KhachService khachService;

// @GetMapping("/ViewAllKhachsList")
// public List<Khach> getAllKhachs() {
// return khachService.getAllKhachs();
// }

// @GetMapping("/ViewKhachById/{id}")
// public Khach getKhacheById(@PathVariable int id) {
// return khachService.getKhachById(id);
// }

// @PostMapping("/CreateNewKhach")
// public Khach createKhach(@RequestBody Khach khach) {
// return khachService.createKhach(khach);
// }

// @DeleteMapping("/DeleteKhach/{id}")
// public void deleteKhach(@PathVariable int id) {
// khachService.deleteKhach(id);
// }
// }
