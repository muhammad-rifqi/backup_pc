package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiController {

    @GetMapping("/api/hello")
    public Map<String, String> getHelloJson() {
        return Map.of("message", "Halo dari API JSON", "nama", "Rifqi");
    }
}
