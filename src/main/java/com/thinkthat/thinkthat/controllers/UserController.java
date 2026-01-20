package com.thinkthat.thinkthat.controllers;

import com.thinkthat.thinkthat.models.UserModal;
import com.thinkthat.thinkthat.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Allows class to handle HTTP requests and responses
@RestController

public class UserController {

    // Declare variable to store service
    private final UserService userService;

    // Inject service so controller can use it
    public UserController(UserService userServ) {
        this.userService = userServ;
    }

    @GetMapping("/users/{id}")
    public UserModal getUserById (@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserModal> getAllUsers () {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public UserModal createUser (@RequestBody UserModal user) {
        return userService.createUser(user);
    }

    @DeleteMapping("users/{id}")
    public void deleteUser (@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PatchMapping("users/{id}")
    public UserModal updateUser (@PathVariable Long id, @RequestBody UserModal user) {
        return userService.updateUser(id, user);
    }
}
