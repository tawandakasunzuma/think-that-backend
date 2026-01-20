package com.thinkthat.thinkthat.services;

import com.thinkthat.thinkthat.dto.CreatePostRequest;
import com.thinkthat.thinkthat.dto.PostResponse;

import java.util.List;

public interface PostService {
    PostResponse createPost (CreatePostRequest request);
    PostResponse getPostById (Long id);
    List<PostResponse> getAllPosts ();
    PostResponse updatePost (Long id, CreatePostRequest request);
    void deletePost (Long id);
}
