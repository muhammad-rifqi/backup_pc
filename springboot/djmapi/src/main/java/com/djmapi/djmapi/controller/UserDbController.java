package com.djmapi.djmapi.controller;

import com.djmapi.djmapi.dao.UserDbDao;
import com.djmapi.djmapi.model.UserDb;
import com.djmapi.djmapi.util.JwtUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/db/users")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000" })
public class UserDbController {

    private final UserDbDao userDbDao;

    public UserDbController(UserDbDao userDbDao) {
        this.userDbDao = userDbDao;
    }

    @GetMapping("/")
    public List<UserDb> getAllUsers() {
        return userDbDao.findAll();
    }

    @GetMapping("/{id}")
    public UserDb getUserById(@PathVariable Long id) {
        return userDbDao.findById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String inputPassword = body.get("password");
        UserDb user = userDbDao.findByEmail(email);
        if (!user.getPassword().equals(inputPassword)) {
            throw new RuntimeException("Email atau password salah");
        }
        String token = JwtUtil.generateToken(user.getEmail());
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", user);
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/search")
    public ResponseEntity<?> search(@RequestParam String keyword) {
        Map<String, Object> response = new HashMap<>();

        List<UserDb> users = userDbDao.search(keyword);

        response.put("success", true);
        response.put("data", users);

        return ResponseEntity.ok(response);
    }

}
