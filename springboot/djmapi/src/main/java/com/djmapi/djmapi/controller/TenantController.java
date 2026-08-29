package com.djmapi.djmapi.controller;

import com.djmapi.djmapi.dao.TenantDao;
import com.djmapi.djmapi.model.Tenant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tenant/")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class TenantController {

    private final TenantDao tenantDao;

    public TenantController(TenantDao tenantDao) {
        this.tenantDao = tenantDao;
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> all() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", tenantDao.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Map<String, Object>> detail(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", tenantDao.findById(id));
        return ResponseEntity.ok(response);
    }

     @GetMapping("/tenant_paging")
    public ResponseEntity<Map<String, Object>> all(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        int totalData = (int) tenantDao.countAll();
        int totalPages = (int) Math.ceil((double) totalData / size);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("currentPage", page);
        response.put("totalPages", totalPages);
        response.put("totalData", totalData);
        response.put("data", tenantDao.findAllPagination(page, size));

        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, String> body) {

        String name = body.get("name");
        String domain = body.get("domain");
        String address = body.get("address");

        Tenant tenant = new Tenant(null, name, domain, address);

        tenantDao.insert(tenant);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Insert berhasil");
        response.put("data", body);

        return ResponseEntity.ok(response);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> update(
            @PathVariable("id") Long id,
            @RequestBody Map<String, String> body) {

        String name = body.get("name");
        String domain = body.get("domain");
        String address = body.get("address");

        Tenant tenant = new Tenant(id, name, domain, address);

        int result = tenantDao.update(tenant);

        Map<String, Object> response = new HashMap<>();

        if (result > 0) {
            response.put("status", "success");
            response.put("message", "Update berhasil");
            response.put("data", tenant);
        } else {
            response.put("status", "failed");
            response.put("message", "Data tidak ditemukan");
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/destroy/{id}")
    public ResponseEntity<Map<String, Object>> destroy(
            @PathVariable("id") Long id) {

        Map<String, Object> res = new HashMap<>();

        tenantDao.delete(id);

        res.put("status", true);
        res.put("message", "Data berhasil dihapus");

        return ResponseEntity.ok(res);
    }

}
