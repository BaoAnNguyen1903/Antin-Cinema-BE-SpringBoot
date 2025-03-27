package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.Khach;
import com.example.antin_cinema_backend.model.repo.KhachRepo;

@Service
public class KhachService {
    @Autowired
    private KhachRepo khachRepo;

    public ArrayList<Khach> getAllKhachs() throws Exception {
        return khachRepo.getAllKhachs();
    }

    public Khach getKhachById(int kid) throws Exception {
        return khachRepo.getKhachById(kid);
    }

    public Khach createKhach(Khach khach) throws Exception {
        khachRepo.createKhach(khach);
        return khach;
    }
}
