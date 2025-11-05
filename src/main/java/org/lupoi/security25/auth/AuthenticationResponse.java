package org.lupoi.security25.auth;

/*
    @author Andrii
    @project security25
    @class AuthenticationResponse
    @version 1.0.0
    @since 05.11.2025 - 12.18
*/

import lombok.*;

@Builder
@Getter
@Setter
public class AuthenticationResponse {

    private String token;
}
