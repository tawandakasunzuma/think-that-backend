package com.thinkthat.thinkthat.dto;

// Structure of user data returned from server to client
// Record: holds data only, once created can't be changed

public record UserResponse(
        Long userId,
        String firstName,
        String lastName,
        String role,
        String emailAddress
) {}

