package com.webapp.app.controller;

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
import org.springframework.web.client.RestTemplate;

import com.webapp.app.dao.UserDao;
import com.webapp.app.model.User;
import com.webapp.app.model.Todo;
import com.webapp.app.util.JwtUtil;
import com.webapp.app.model.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000" })
public class UserController {

    private final UserDao userDao;
    private final RestTemplate restTemplate;

    public UserController(UserDao userDao, RestTemplate restTemplate) {
        this.userDao = userDao;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllUser() {
        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("data", userDao.findAll());
        return ResponseEntity.ok(res);

    }

    @GetMapping("/list")
    public List<Array> getArray() {
        List<Array> arr = new ArrayList<>();
        arr.add(new Array(1L, "rifqi", "rifqi@localhost"));
        arr.add(new Array(2L, "budi", "budi@localhost"));
        arr.add(new Array(3L, "sinta", "sinta@localhost"));
        return arr;
    }

    @GetMapping("external/{id}")
    public ResponseEntity<Map<String, Object>> getExternal(@PathVariable("id") Long id) {

        String url = "https://jsonplaceholder.typicode.com/todos/" + id;

        Todo todo = restTemplate.getForObject(url, Todo.class);

        Map<String, Object> responsenya = new HashMap<>();
        responsenya.put("success", true);
        responsenya.put("data", todo);

        return ResponseEntity.ok(responsenya);
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
        String email = body.get("email");
        String password = body.get("password");
        String username = body.get("username");
        String roles = body.get("roles");

        User user = new User(null, email, password, username, roles);

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
            res.put("data", e);
            return ResponseEntity.ok(res);
        }
    }

}
