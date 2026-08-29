package com.employee.apps.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.apps.dao.RoleDao;
import com.employee.apps.model.Role;
import org.springframework.web.client.RestTemplate;
import com.employee.apps.model.Todo;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/role/")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000" })
public class RoleController {

    private final RoleDao roleDao;
    private final RestTemplate restTemplate;

    public RoleController(RoleDao roleDao, RestTemplate restTemplate) {
        this.roleDao = roleDao;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> responsenya = new HashMap<>();
        responsenya.put("success", true);
        responsenya.put("data", roleDao.allData());
        return ResponseEntity.ok(responsenya);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Map<String, Object> responsenya = new HashMap<>();
        responsenya.put("success", true);
        responsenya.put("data", roleDao.detailById(id));
        return ResponseEntity.ok(responsenya);
    }

    @PostMapping("/store")
    public ResponseEntity<Map<String, Object>> store(@RequestBody Map<String, String> body) {
        String roles_name = body.get("roles_name");
        String description = body.get("description");

        Role role = new Role(null, roles_name, description);

        roleDao.create(role);

        Map<String, Object> respo = new HashMap<>();
        respo.put("success", true);
        return ResponseEntity.ok(respo);
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

}
