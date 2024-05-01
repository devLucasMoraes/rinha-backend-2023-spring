package com.api.rinhabackend2023spring.service.exception;

import java.io.Serial;

public class NotFoundException extends UnprocessableEntityException{
    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("Resource not found.");
    }
}
