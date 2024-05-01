package com.api.rinhabackend2023spring.service.exception;

import java.io.Serial;

public class UnprocessableEntityException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public UnprocessableEntityException(String message) {
        super(message);
    }
}
