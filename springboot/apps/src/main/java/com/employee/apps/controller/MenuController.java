package com.employee.apps.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.apps.dao.MenuDao;
import com.employee.apps.model.Menu;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/menu/")
public class MenuController {

    private final MenuDao menuDao;

    public MenuController(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", menuDao.menuall());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", menuDao.findById(id));
        return ResponseEntity.ok(response);
    }

    @PostMapping("store")
    public ResponseEntity<Map<String, Object>> store(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        Long role_id = Long.parseLong(body.get("role_id"));
        String url = body.get("url");

        Menu menu = new Menu(null, name, role_id, url);
        menuDao.create(menu);

        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        return ResponseEntity.ok(res);
    }

}
