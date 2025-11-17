package org.lupoi.security25.security;/*
    @author Andrii
    @project security25
    @class UserDetailsServiceImpl
    @version 1.0.0
    @since 05.11.2025 - 13.06
*/

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.lupoi.security25.user.Role;
import org.lupoi.security25.user.User;
import org.lupoi.security25.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

//     @PostConstruct
//     void init() {
//          User user = User.builder()
//                  .firstName("John")
//                  .lastName("Lennon")
//                  .email("john@mail.com")
//                  .password(passwordEncoder.encode("password"))
//                  .enabled(true)
//                  .accountLocked(false)
//                  .roles(List.of(Role.USER))
//                  .build();
//         repository.save(user);
//
//         User use1 = User.builder()
//                 .firstName("Adic")
//                 .lastName("Stomber")
//                 .email("adic@mail.com")
//                 .password(passwordEncoder.encode("passAdic"))
//                 .enabled(true)
//                 .accountLocked(false)
//                 .roles(List.of(Role.SUPERADMIN))
//                 .build();
//         repository.save(use1);
//  }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return repository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}