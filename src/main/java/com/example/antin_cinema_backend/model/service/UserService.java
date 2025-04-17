package com.example.antin_cinema_backend.model.service;

import com.example.antin_cinema_backend.model.dto.UserUpdateDTO;
import com.example.antin_cinema_backend.model.entity.User;
import com.example.antin_cinema_backend.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public boolean updateUser(UserUpdateDTO dto) throws Exception {
        User existingUser = userRepo.getUserById(dto.getUid()); // cần hàm này
        if (existingUser == null) {
            return false;
        }

        // Cập nhật từng trường nếu khác null
        if (dto.getName() != null)
            existingUser.setName(dto.getName());
        if (dto.getDob() != null)
            existingUser.setDob(dto.getDob());
        if (dto.getGender() != null)
            existingUser.setGender(dto.getGender());
        if (dto.getPhone() != null)
            existingUser.setPhone(dto.getPhone());
        if (dto.getEmail() != null)
            existingUser.setEmail(dto.getEmail());
        if (dto.getPoints() != null)
            existingUser.setPoints(dto.getPoints());

        userRepo.updateUserById(existingUser);
        return true;
    }

    public boolean checkPassword(int uid, String oldPassword) throws Exception {
        return userRepo.checkPassword(uid, oldPassword);
    }

    public Map<String, Object> getUsers(int current, int pageSize, String name, String email) {
        int offset = (current - 1) * pageSize;

        String baseSql = "SELECT * FROM users WHERE 1=1";
        String countSql = "SELECT COUNT(*) FROM users WHERE 1=1";

        List<Object> params = new ArrayList<>();
        List<Object> countParams = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            baseSql += " AND name LIKE ?";
            countSql += " AND name LIKE ?";
            params.add("%" + name + "%");
            countParams.add("%" + name + "%");
        }

        if (email != null && !email.isEmpty()) {
            baseSql += " AND email LIKE ?";
            countSql += " AND email LIKE ?";
            params.add("%" + email + "%");
            countParams.add("%" + email + "%");
        }

        baseSql += " LIMIT ? OFFSET ?";
        params.add(pageSize);
        params.add(offset);

        List<User> users = jdbcTemplate.query(baseSql, params.toArray(), new BeanPropertyRowMapper<>(User.class));
        int total = jdbcTemplate.queryForObject(countSql, countParams.toArray(), Integer.class);

        Map<String, Object> result = new HashMap<>();
        result.put("result", users);

        Map<String, Object> meta = new HashMap<>();
        meta.put("current", current);
        meta.put("pageSize", pageSize);
        meta.put("total", total);
        result.put("meta", meta);

        return result;
    }
}
