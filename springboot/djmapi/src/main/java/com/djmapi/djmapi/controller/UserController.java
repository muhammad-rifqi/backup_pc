package com.djmapi.djmapi.controller;

import com.djmapi.djmapi.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class UserController {

    @GetMapping("/")
    public String home() {
        return "API DJM Jalan 🚀";
    }

    @GetMapping("/list")
    public List<User> getUsers() {

        List<User> users = new ArrayList<>();
        users.add(new User(1L, "rifqi", "rifqi@localhost"));
        users.add(new User(2L, "budi", "budi@localhost"));
        users.add(new User(3L, "sinta", "sinta@localhost"));

        return users;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, String> body) {
        String id = body.get("id");
        String name = body.get("name");
        String email = body.get("email");

        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("name", name);
        response.put("email", email);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/testing")
    public ResponseEntity<Map<String, Object>> testing(@RequestBody Map<String, String> body){
            String nama = body.get("nama");
            String email = body.get("email");

        Map<String, Object> resp = new HashMap<>();
        resp.put("nama", nama);
         resp.put("email", email);

         return ResponseEntity.ok(resp);
    }

}
