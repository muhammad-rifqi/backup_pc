package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class PersonApiController {

    private final PersonRepository repository;

    public PersonApiController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Users> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Users create(@RequestBody Users person) {
        return repository.save(person);
    }
}
