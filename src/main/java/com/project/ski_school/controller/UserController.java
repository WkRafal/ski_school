package com.project.ski_school.controller;

import com.project.ski_school.model.User;
import com.project.ski_school.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/users")
    ResponseEntity<?> createUser(@RequestBody User createUser) {
        User result = repository.save(createUser);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/users")
    ResponseEntity<?> readAllUsers() {
        return ResponseEntity.ok(repository.findAll());
    }
}
