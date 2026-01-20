package com.thinkthat.thinkthat.controllers;

import com.thinkthat.thinkthat.dto.CreateUserRequest;
import com.thinkthat.thinkthat.dto.UserResponse;
import com.thinkthat.thinkthat.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Allows class to handle HTTP requests and responses
@RestController
@RequestMapping("/users") // Base path for all user endpoints
public class UserController {

    // Declare variable to store service
    private final UserService userService;

    // Inject service so controller can use it
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Get all users
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    // Create a new user
    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    // Update an existing user
    @PatchMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody CreateUserRequest request) {
        return userService.updateUser(id, request);
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
