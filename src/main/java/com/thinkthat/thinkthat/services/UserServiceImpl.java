package com.thinkthat.thinkthat.services;

import com.thinkthat.thinkthat.dto.CreateUserRequest;
import com.thinkthat.thinkthat.dto.UserResponse;
import com.thinkthat.thinkthat.models.UserModal;
import com.thinkthat.thinkthat.respositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Marks class as service
@Service
public class UserServiceImpl implements UserService {

    // Declare variable to store database helper
    private final UserRepository userRepository;

    // Receive helper from Spring
    public UserServiceImpl(UserRepository userRepository) {
        // Store helper in variable so service can use it
        this.userRepository = userRepository;
    }

    // Create a new user
    @Override
    public UserResponse createUser(CreateUserRequest request) {
        UserModal user = new UserModal();
        user.setFirstName(request.firstName);
        user.setLastName(request.lastName);
        user.setRole(request.role);
        user.setEmailAddress(request.emailAddress);
        user.setPassword(request.password);

        // Save user, ID automatically generated
        // Return user mapped to UserResponse
        return map(userRepository.save(user));
    }

    // Get a user by ID
    @Override
    public UserResponse getUserById(Long id) {
        // Retrieve user (Optional: may or may not be present)
        return userRepository.findById(id)
                .map(this::map) // Map UserModal to UserResponse if present
                .orElse(null);  // Return null if user doesn't exist
    }

    // Get all users
    @Override
    public List<UserResponse> getAllUsers() {
        // Retrieve all users and map each to UserResponse
        return userRepository.findAll().stream()
                .map(this::map)
                .toList();
    }

    // Update an existing user
    @Override
    public UserResponse updateUser(Long id, CreateUserRequest request) {
        // Retrieve user (Optional: may or may not be present)
        Optional<UserModal> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) return null; // Return null if user doesn't exist

        // If user exists, fetch user object
        UserModal user = optionalUser.get();
        user.setFirstName(request.firstName);
        user.setLastName(request.lastName);
        user.setRole(request.role);
        user.setEmailAddress(request.emailAddress);
        user.setPassword(request.password);

        // Save updated user and return mapped response
        return map(userRepository.save(user));
    }

    // Delete a user by ID
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Map UserModal to UserResponse
    private UserResponse map(UserModal user) {
        return new UserResponse(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getEmailAddress()
        );
    }
}
