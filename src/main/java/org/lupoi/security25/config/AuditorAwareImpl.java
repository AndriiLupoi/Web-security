package org.lupoi.security25.config;/*
    @author Andrii
    @project security25
    @class AuditorAwareImpl
    @version 1.0.0
    @since 29.10.2025 - 11.42
*/

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(System.getProperty("user.name"));
    }
}
