package org.lupoi.security25.user;/*
    @author user
    @project security25
    @class UserController
    @version 1.0.0
    @since 24.09.2025 - 11.08
*/

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserRestController {

    private final UserService service;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public List<User> getUsers() {
        return service.getAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public User getOneUser(@PathVariable String id) {
        return service.getById(id);
    }

    @PreAuthorize("hasRole('SUPERADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    @PutMapping
    public User uptade(@RequestBody User user) {
        return service.uptade(user);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/hello/user")
    public String helloUser() {
        return "Hello User!";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("hello/admin")
    public String helloAdmin() {
        return "Hello Admin!";
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("hello/unknown")
    public String helloUnknown() {
        return "Hello unknown!";
    }

    @GetMapping("hello/stranger")
    public String helloStranger() {
        return "Hello Stranger!";
    }


}
