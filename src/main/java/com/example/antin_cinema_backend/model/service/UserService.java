package com.example.antin_cinema_backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.antin_cinema_backend.model.entity.User;
import com.example.antin_cinema_backend.model.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(int uid) {
        return userRepo.findById(uid).orElse(null);
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(int uid) {
        userRepo.deleteById(uid);
    }
}
