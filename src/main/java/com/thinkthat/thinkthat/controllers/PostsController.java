package com.thinkthat.thinkthat.controllers;

import com.thinkthat.thinkthat.models.PostsModal;
import com.thinkthat.thinkthat.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Allows class to handle HTTP requests and responses
@RestController

public class PostsController {

    // Declare variable to handle service
    private final PostService postService;

    // Inject service so controller can use it
    public PostsController(PostService postServ) {
        this.postService = postServ;
    }

    @GetMapping("/posts/{id}")
    public PostsModal getPostById (@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping("/posts")
    public List<PostsModal> getAllPosts () {
        return postService.getAllPosts();
    }

    @PostMapping("/posts")
    public PostsModal createPost (@RequestBody PostsModal post) {
        return postService.createPost(post);
    }

    @PatchMapping("/posts/{id}")
    public PostsModal updatePost (@RequestBody PostsModal post, @PathVariable Long id) {
        return postService.updateUser(post, id);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost (@PathVariable Long id) {
        postService.deletePost(id);
    }
}
