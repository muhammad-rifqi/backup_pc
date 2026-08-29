package com.employee.apps.controller;

import com.employee.apps.dao.UserDao;
import com.employee.apps.model.User;
import com.employee.apps.util.JwtUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000" })
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> all() {
        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("data", userDao.findAll());
        return ResponseEntity.ok(res);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Map<String, Object>> detail(@PathVariable("id") Long id) {
        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("data", userDao.findById(id));
        return ResponseEntity.ok(res);
    }

    @PostMapping("/store")
    public ResponseEntity<Map<String, Object>> store(@RequestBody Map<String, String> body) {
        String nama = body.get("nama");
        String email = body.get("email");
        String password = body.get("password");
        String status = body.get("status");

        User user = new User(null, email, password, nama, status);

        userDao.create(user);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("destroy/{id}")
    public ResponseEntity<Map<String, Object>> destroy(@PathVariable("id") Long id) {
        Map<String, Object> res = new HashMap<>();
        userDao.delete(id);
        res.put("success", true);
        return ResponseEntity.ok(res);

    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String inputPassword = body.get("password");

        User user = userDao.findByEmail(email);
        System.out.println("Email: " + email);
        System.out.println("Password: " + inputPassword);
        System.out.println("EmailDB: " + user.getEmail());
        System.out.println("PasswordDB: " + user.getPassword());
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

    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> profile(@RequestHeader("Authorization") String authHeaders) {
        Map<String, Object> res = new HashMap<>();
        try {

            String token = authHeaders.replace("Bearer", "");
            String email = JwtUtil.validateToken(token);
            User user = userDao.findByEmail(email);

            res.put("success", true);
            res.put("data", user);
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);

        } catch (Exception e) {
            res.put("success", false);
            res.put("data", null);
            return ResponseEntity.ok(res);
        }
    }

}
