package ua.dragunov.watchlyapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.dragunov.watchlyapi.exception.DuplicateEntityException;
import ua.dragunov.watchlyapi.exception.EntityNotFoundException;

import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Map<String, String>> userNotFound(UsernameNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "error", "User not found"
                        , "message", ex.getMessage()
                ));

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> entityNotFound(EntityNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "error", "Entity Not Found",
                        "message", ex.getMessage()
                ));
    }

    @ExceptionHandler(DuplicateEntityException.class)
    public ResponseEntity<Map<String, String>> entityNotFound(DuplicateEntityException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "error", "Duplicate Entity",
                        "message", ex.getMessage()
                ));
    }
}
