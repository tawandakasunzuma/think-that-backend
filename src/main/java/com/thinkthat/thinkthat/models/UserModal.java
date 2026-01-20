package com.thinkthat.thinkthat.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

// Getters and Setters for modal fields
@Getter
@Setter

// Represent database entity
@Entity

// Represent table name
@Table (name = "users")

public class UserModal {

    // Primary key
    @Id
    // Auto generate ID by database sequence
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Fields
    private Long userId;
    private String firstName;
    private String lastName;
    private String role;
    private String emailAddress;

    // Password hidden when reading/fetching data
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    // Declare relationship
    // 'mapped': tells this modal which field in the other modal owns the link
    // 'cascade': actions on user affect its posts
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    // Retrieve posts created by user
    private List<PostsModal> posts;

}
