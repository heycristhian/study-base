package br.com.heycristhian.studybase.controller;

import br.com.heycristhian.studybase.entity.domain.User;
import br.com.heycristhian.studybase.entity.response.UserResponse;
import br.com.heycristhian.studybase.exception.UserNotFoundException;
import br.com.heycristhian.studybase.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper modelMapper;

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
    public ResponseEntity<User> save(@Valid @RequestBody UserResponse userResponse) {
        User user = modelMapper.map(userResponse, User.class);
        return ResponseEntity.ok(service.save(user));
    }
}
