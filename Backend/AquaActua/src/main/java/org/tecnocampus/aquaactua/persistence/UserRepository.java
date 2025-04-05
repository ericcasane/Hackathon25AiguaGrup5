package org.tecnocampus.aquaactua.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecnocampus.aquaactua.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmailAndPassword(String email, String password);
}
