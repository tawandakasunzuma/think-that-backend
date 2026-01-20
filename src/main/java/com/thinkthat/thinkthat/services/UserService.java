package com.thinkthat.thinkthat.services;

import com.thinkthat.thinkthat.models.PostsModal;
import com.thinkthat.thinkthat.models.UserModal;
import com.thinkthat.thinkthat.respositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Marks class as service
@Service

public class UserService {

    // Declare variable to store database helper
    private final UserRepository userRepository;

    // Receive helper from Spring
    public UserService(UserRepository userRepo) {

        // Store helper in variable so service can use it
        this.userRepository = userRepo;
    }

    public UserModal getUserById (Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<UserModal> getAllUsers () {
        return userRepository.findAll();
    }

    public UserModal createUser (UserModal user) {

        /* = Code broken down = */
        // userRepository.save(user);
        // return user;

        /* = Best practice = */
        // Save user, ID automatically generated
        // Return user to communicate results
        return userRepository.save(user);
    }

    public void deleteUser (Long id) {

        // Retrieve user (Optional: may or may not be present)
        Optional <UserModal> optionalUser = userRepository.findById(id);

        // If user exists delete user
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        }

    }

    public UserModal updateUser (Long id, UserModal user) {

        // Retrieve user by ID
        Optional <UserModal> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            // Get user object
            UserModal existingUser = optionalUser.get();

            // Update fields
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmailAddress(user.getEmailAddress());
            existingUser.setPassword(user.getPassword());

            // Save updated user and return it
            return userRepository.save(existingUser);

        } else {

            // If user not found return nothing
            return null;
        }
    }
}
