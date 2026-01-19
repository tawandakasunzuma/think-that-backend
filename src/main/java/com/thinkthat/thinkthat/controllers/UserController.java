package com.thinkthat.thinkthat.controllers;

import com.thinkthat.thinkthat.models.UserModal;
import com.thinkthat.thinkthat.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/users")
    public UserModal createUser (@PathVariable UserModal user) {
        return userService.createUser(user);
    }
}
