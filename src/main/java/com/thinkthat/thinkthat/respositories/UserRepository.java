package com.thinkthat.thinkthat.respositories;

import com.thinkthat.thinkthat.models.UserModal;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA generates CRUD database methods for UserModal
public interface UserRepository extends JpaRepository<UserModal, Long> {
}
