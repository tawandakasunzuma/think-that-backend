package com.thinkthat.thinkthat.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

// Getters and Setters for modal fields
@Getter
@Setter

// Represent database entity
@Entity

// Represent table name
@Table(name = "posts")

public class PostsModal {

    // Primary key
    @Id
    // Auto generate ID by database sequence
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Fields
    private Long postId;
    private String title;
    private String description;
    private LocalDateTime createdAt;

    // Declare relationship
    @ManyToOne
    // Create column called userId, column is foreign key
    // Column cannot be null
    @JoinColumn(name = "userId", nullable = false)
    // Object stored as a user ID
    private UserModal user;
}
