package com.thinkthat.thinkthat.controllers;

import com.thinkthat.thinkthat.dto.CreatePostRequest;
import com.thinkthat.thinkthat.dto.PostResponse;
import com.thinkthat.thinkthat.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Allows class to handle HTTP requests and responses
@RestController
@RequestMapping("/posts") // Base path for all post endpoints
public class PostsController {

    // Declare variable to handle service
    private final PostService postService;

    // Inject service so controller can use it
    public PostsController(PostService postService) {
        this.postService = postService;
    }

    // Get a post by ID
    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    // Get all posts
    @GetMapping
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    // Create a new post
    @PostMapping
    public PostResponse createPost(@RequestBody CreatePostRequest request) {
        return postService.createPost(request);
    }

    // Update an existing post
    @PatchMapping("/{id}")
    public PostResponse updatePost(@RequestBody CreatePostRequest request, @PathVariable Long id) {
        return postService.updatePost(id, request);
    }

    // Delete a post by ID
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
