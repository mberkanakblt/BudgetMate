package com.mehmetberkan.repository;

import com.mehmetberkan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOptionalByEmailAndPassword(String email, String password);
}
