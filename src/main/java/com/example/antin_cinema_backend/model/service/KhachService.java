// package com.example.antin_cinema_backend.model.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.example.antin_cinema_backend.model.entity.Khach;
// import com.example.antin_cinema_backend.model.repo.KhachRepo;

// @Service
// public class KhachService {
// @Autowired
// private KhachRepo khachRepo;

// public List<Khach> getAllKhachs() {
// return khachRepo.findAll();
// }

// public Khach getKhachById(int kid) {
// return khachRepo.findById(kid).orElse(null);
// }

// public Khach createKhach(Khach khach) {
// return khachRepo.save(khach);
// }

// public void deleteKhach(int kid) {
// khachRepo.deleteById(kid);
// }
// }
