package org.lupoi.security25.user;/*
    @author user
    @project security25
    @class UserRepository
    @version 1.0.0
    @since 24.09.2025 - 11.05
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
