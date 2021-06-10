package br.com.heycristhian.studybase.controller;

import br.com.heycristhian.studybase.entity.User;
import br.com.heycristhian.studybase.exception.UserNotFoundException;
import br.com.heycristhian.studybase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}