package com.api.rinhabackend2023spring.controller.exception;

import java.time.LocalDateTime;

public record StandardError(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {
}
