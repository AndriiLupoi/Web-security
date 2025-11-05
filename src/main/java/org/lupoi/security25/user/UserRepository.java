package org.lupoi.security25.user;/*
    @author Andrii
    @project security25
    @class UserRepository
    @version 1.0.0
    @since 05.11.2025 - 13.05
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
