// src/main/java/com/clinicavet/repository/UserRepository.java
package com.clinicavet.repository;

import com.clinicavet.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
