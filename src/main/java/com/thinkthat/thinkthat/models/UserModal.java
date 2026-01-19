package com.thinkthat.thinkthat.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

// Getters and Setters for modal fields
@Getter
@Setter

// Represent database entity
@Entity

// Represent table name
@Table (name = "users")

public class UserModal {

    // Primary key fields
    @Id
    // Auto generate ID by database sequence
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Fields
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private String emailAddress;

    // Password hidden when reading/fetching data
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
