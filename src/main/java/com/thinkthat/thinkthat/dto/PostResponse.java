package com.thinkthat.thinkthat.dto;

import java.time.LocalDateTime;

// Structure of post data returned from server to client
// Record: holds data only, once created can't be changed

public record PostResponse(
        Long postId,
        String title,
        String description,
        LocalDateTime createdAt,
        Long userId
) {}
