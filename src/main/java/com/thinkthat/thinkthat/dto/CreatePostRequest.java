package com.thinkthat.thinkthat.dto;

import java.time.LocalDateTime;

// Structure of data sent by client to create post

public class CreatePostRequest {
    public String title;
    public String description;
    public LocalDateTime createdAt;
    public Long userId;
}
