package com.thinkthat.thinkthat.respositories;

import com.thinkthat.thinkthat.models.UserModal;
import org.springframework.data.jpa.repository.JpaRepository;

// Get built in methods automatically
public interface UserRepository extends JpaRepository<UserModal, Long> {
}
