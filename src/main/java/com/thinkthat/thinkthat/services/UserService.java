package com.thinkthat.thinkthat.services;

import com.thinkthat.thinkthat.dto.CreateUserRequest;
import com.thinkthat.thinkthat.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser (CreateUserRequest request);
    UserResponse getUserById (Long id);
    List<UserResponse> getAllUsers();
    UserResponse updateUser (Long id, CreateUserRequest request);
    void deleteUser(Long id);
}
