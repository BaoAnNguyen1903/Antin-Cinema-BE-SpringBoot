package com.example.antin_cinema_backend.model.service;

import com.example.antin_cinema_backend.model.entity.User;
import com.example.antin_cinema_backend.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public PaginatedResult<User> getUsersPaginated(int current, int pageSize) throws Exception {
        List<User> allUsers = userRepo.getAllUsers(); // Lấy danh sách tất cả user
        int total = allUsers.size();

        int fromIndex = Math.max((current - 1) * pageSize, 0);
        int toIndex = Math.min(fromIndex + pageSize, total);

        List<User> paginatedList = new ArrayList<>();
        if (fromIndex < toIndex) {
            paginatedList = allUsers.subList(fromIndex, toIndex);
        }

        return new PaginatedResult<>(paginatedList, total);
    }

    public User getUserById(int uid) throws Exception {
        // if(uid == null){

        // }
        return userRepo.getUserById(uid);
    }

    public User createUser(User user) throws Exception {
        if (userRepo.existsByUsername(user.getUsername()) || userRepo.existsByEmail(user.getEmail())) {
            return null; // Trả về false nếu username hoặc email đã tồn tại
        }
        System.out.println("check User " + user);
        userRepo.createUser(user);

        return user;
    }

    public boolean updateUser(User user) throws Exception {
        if (!userRepo.existsByUsername(user.getUsername())) {
            return false; // Trả về false nếu user không tồn tại
        }
        userRepo.updateUserById(user);
        return true;
    }

    public boolean checkPassword(int uid, String oldPassword) throws Exception {
        return userRepo.checkPassword(uid, oldPassword);
    }
}
