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
        users.add(new User("hiadj", "firstaasd", "asd@gmail.com"));
        users.add(new User("hiadj2", "firstaasd2", "asd2@gmail.com"));
        users.add(new User("hiadj3", "firstaasd3", "asd3@gmail.com"));
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
