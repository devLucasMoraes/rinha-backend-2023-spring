package com.api.rinhabackend2023spring.controller.exception;

import com.api.rinhabackend2023spring.service.exception.NotFoundException;
import com.api.rinhabackend2023spring.service.exception.UnprocessableEntityException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<StandardError> handleUnprocessableEntityException(UnprocessableEntityException exc, HttpServletRequest req) {
        return sendResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY, exc.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> handleNoContentException(NotFoundException exc, HttpServletRequest req) {
        return sendResponseEntity(HttpStatus.NOT_FOUND, exc.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exc, HttpServletRequest req) {
        return sendResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY, exc.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
        String message = "Unexpected server error.";
        LOGGER.error(message, unexpectedException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<StandardError> sendResponseEntity(HttpStatus status, String errorMessage, String reqURI) {
        var standardError = new StandardError(
            LocalDateTime.now(), status.value(), status.getReasonPhrase(), errorMessage, reqURI
        );

        return ResponseEntity.status(status).body(standardError);
    };
}
