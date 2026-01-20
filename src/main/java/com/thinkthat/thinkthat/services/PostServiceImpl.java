package com.thinkthat.thinkthat.services;

import com.thinkthat.thinkthat.dto.CreatePostRequest;
import com.thinkthat.thinkthat.dto.PostResponse;
import com.thinkthat.thinkthat.models.PostsModal;
import com.thinkthat.thinkthat.models.UserModal;
import com.thinkthat.thinkthat.respositories.PostRepository;
import com.thinkthat.thinkthat.respositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Marks class as service
@Service
public class PostServiceImpl implements PostService {

    // Declare variables to store database helpers
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // Receive helpers from Spring
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        // Store helpers in variables so service can use them
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    // Create a new post
    @Override
    public PostResponse createPost(CreatePostRequest request) {
        // Retrieve user by ID, throw exception if not found
        UserModal user = userRepository.findById(request.userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create new post and set fields from request
        PostsModal post = new PostsModal();
        post.setTitle(request.title);
        post.setDescription(request.description);
        post.setCreatedAt(request.createdAt);
        post.setUser(user);

        // Save post, ID automatically generated
        // Return post mapped to PostResponse
        return map(postRepository.save(post));
    }

    // Get a post by ID
    @Override
    public PostResponse getPostById(Long id) {
        // Retrieve post (Optional: may or may not be present)
        return postRepository.findById(id)
                .map(this::map) // Map PostsModal to PostResponse if present
                .orElse(null);  // Return null if post doesn't exist
    }

    // Get all posts
    @Override
    public List<PostResponse> getAllPosts() {
        // Retrieve all posts and map each to PostResponse
        return postRepository.findAll().stream()
                .map(this::map)
                .toList();
    }

    // Update an existing post
    @Override
    public PostResponse updatePost(Long id, CreatePostRequest request) {
        // Retrieve post by ID (Optional: may or may not be present)
        Optional<PostsModal> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) return null; // Return null if post doesn't exist

        // If post exists, fetch post object
        PostsModal post = optionalPost.get();
        post.setTitle(request.title);
        post.setDescription(request.description);
        post.setCreatedAt(request.createdAt);

        // Save updated post and return mapped response
        return map(postRepository.save(post));
    }

    // Delete a post by ID
    @Override
    public void deletePost(Long id) {
        // Delete post directly by ID
        postRepository.deleteById(id);
    }

    // Map PostsModal to PostResponse
    private PostResponse map(PostsModal post) {
        return new PostResponse(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getCreatedAt(),
                post.getUser().getUserId()
        );
    }
}
