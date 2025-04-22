package com.example.antin_cinema_backend.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.Khach;
import com.example.antin_cinema_backend.model.entity.User;
import com.example.antin_cinema_backend.model.repo.KhachRepo;

@Service
public class KhachService {
    @Autowired
    private KhachRepo khachRepo;

    public PaginatedResult<Khach> getUsersPaginated(int current, int pageSize) throws Exception {
        List<Khach> allGuests = khachRepo.getAllKhachs();
        int total = allGuests.size();

        int fromIndex = Math.max((current - 1) * pageSize, 0);
        int toIndex = Math.min(fromIndex + pageSize, total);

        List<Khach> paginatedList = new ArrayList<>();
        if (fromIndex < toIndex) {
            paginatedList = allGuests.subList(fromIndex, toIndex);
        }

        return new PaginatedResult<>(paginatedList, total);
    }

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
