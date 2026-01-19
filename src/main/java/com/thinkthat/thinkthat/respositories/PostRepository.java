package com.thinkthat.thinkthat.respositories;

import com.thinkthat.thinkthat.models.PostsModal;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA generates CRUD database methods for PostModal
public interface PostRepository extends JpaRepository<PostsModal, Long> {
}
