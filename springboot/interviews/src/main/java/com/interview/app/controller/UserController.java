package com.interview.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

import com.interview.app.dao.UserDao;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", userDao.allList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/interview")
    public ResponseEntity<Map<String, Object>> AmbilNilai () {
        Map<String, Object> response =  new HashMap<>();
        try {
            int x = 15;
            int y = 6;
            int temp = x;
            x = y;
            y = temp;
            response.put("x", x);
            response.put("y", y);
           
        } catch (Exception e) {
            response.put("success" , false);
        }
         return ResponseEntity.ok(response);
    }

}
