package com.WkRafal.ski_school.controller;


import com.WkRafal.ski_school.model.Role;
import com.WkRafal.ski_school.model.User;
import com.WkRafal.ski_school.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    ResponseEntity<?> createUser(@RequestBody User createUser) {
        User result = repository.save(createUser);
        logger.info("save user");
        return ResponseEntity.created(URI.create("/" + result.getUserID())).body(result);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> readUser(@PathVariable int id) {
        logger.info("find by id");
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    ResponseEntity<?> readAllUsers() {
        return ResponseEntity.ok(repository.findAll());
    }

//    @PostMapping
//    public ResponseEntity<Uzytkownik> dodajUzytkownika(@RequestBody Uzytkownik uzytkownik) {
//        Uzytkownik nowyUzytkownik = uzytkownikService.dodajUzytkownika(uzytkownik);
//        return ResponseEntity.ok(nowyUzytkownik);
//    }

    @GetMapping("/role/{role}")
    ResponseEntity<List<User>> findUserByRole(@PathVariable Role role) {
        List<User> users = repository.findUserByRole(role);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User update) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(user -> {
                    user.updateFrom(update);
                    repository.save(user);
                });
        logger.info("update");
        return ResponseEntity.noContent().build();
    }

}
