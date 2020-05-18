package com.marcoscouto.office.resource;

import com.marcoscouto.office.domain.User;
import com.marcoscouto.office.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<User>> findAll() {
        List<User> response = userService.findAll();
        if (response.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        User response = userService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<User> save(@RequestBody User user) {
        User response = userService.save(user);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody User user) {
        User response = userService.update(id, user);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/refresh")
    public ResponseEntity<Void> refreshDatabase() {
        userService.refreshDatabase();
        return ResponseEntity.ok().build();
    }


}
