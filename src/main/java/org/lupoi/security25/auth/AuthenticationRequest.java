package org.lupoi.security25.auth;

/*
    @author Andrii
    @project security25
    @class AuthenticationRequest
    @version 1.0.0
    @since 05.11.2025 - 12.15
*/

import lombok.Data;
import lombok.NonNull;

@Data
public class AuthenticationRequest {

    @NonNull
    private String login;
    @NonNull
    private String password;
}
