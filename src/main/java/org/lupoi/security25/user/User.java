package org.lupoi.security25.user;/*
    @author user
    @project security25
    @class User
    @version 1.0.0
    @since 24.09.2025 - 11.00
*/

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

    @Id
    private String id;

    private String userFirstName;
    private String userLastName;
    private String email;
    private String password;
    private String nickname;


    public User(String userFirstName, String userLastName, String email, String password, String nickname) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
