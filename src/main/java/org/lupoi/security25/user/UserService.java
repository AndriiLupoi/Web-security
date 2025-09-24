package org.lupoi.security25.user;/*
    @author user
    @project security25
    @class UserService
    @version 1.0.0
    @since 24.09.2025 - 11.06
*/

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    private List<User> users;

    @PostConstruct
    public void init() {
        users.add(new User("userFirstName1", "userLastName1", "userEmail1@gmail.com", "12345678", "user1"));
        users.add(new User("userFirstName2", "userLastName2", "userEmail2@gmail.com", "87654321", "user2"));
        users.add(new User("userFirstName3", "userLastName3", "userEmail3@gmail.com", "13247586", "user3"));
        repository.saveAll(users);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User uptade(User user) {
        return repository.save(user);
    }
}
