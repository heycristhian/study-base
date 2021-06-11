package br.com.heycristhian.studybase.controller;

import br.com.heycristhian.studybase.entity.User;
import br.com.heycristhian.studybase.exception.UserNotFoundException;
import br.com.heycristhian.studybase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<User> findById(@PathVariable UUID uuid) {
        User user = service.findById(uuid).orElseThrow(() -> new UserNotFoundException(uuid));
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User savedUser = service.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
