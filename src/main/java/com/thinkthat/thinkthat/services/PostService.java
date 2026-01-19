package com.thinkthat.thinkthat.services;

import com.thinkthat.thinkthat.models.PostsModal;
import com.thinkthat.thinkthat.models.UserModal;
import com.thinkthat.thinkthat.respositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Marks class as service
@Service

public class PostService {

    // Declare variable to store database helper
    private final PostRepository postRepository;

    // Receive helper from Spring
    public PostService(PostRepository postRepo) {

        // Store helper in variable so service can use it
        this.postRepository = postRepo;
    }

    public PostsModal getPostById (Long id) {
        return  postRepository.findById(id).orElse(null);
    }

    public List <PostsModal> getAllPosts () {
        return postRepository.findAll();
    }

    public PostsModal createPost (PostsModal post) {

        // Save user, ID automatically generated
        // Return user to communicate results
        return postRepository.save(post);
    }

    public void deletePost (Long id) {

        // Retrieve user (Optional: may or may not be present)
        Optional <PostsModal> optionalPost = postRepository.findById(id);

        // If user exists delete user
        if (optionalPost.isPresent()) {
            postRepository.deleteById(id);
        }

    }

    public PostsModal updateUser (PostsModal post, Long id) {

        // Retrieve user (Optional: may or may not be present)
        Optional <PostsModal> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()) {
            // If user exists fetch post object
            PostsModal existingModal = optionalPost.get();

            // Update fields
            existingModal.setTitle(post.getTitle());
            existingModal.setDescription(post.getDescription());
            existingModal.setCreatedAt(post.getCreatedAt());
        }

        // Return nothing if post doesn't exist
        return null;
    }


}
