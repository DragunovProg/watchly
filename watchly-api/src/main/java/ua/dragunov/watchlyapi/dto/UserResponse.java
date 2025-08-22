package ua.dragunov.watchlyapi.dto;

import ua.dragunov.watchlyapi.model.Gender;

import java.time.LocalDate;

public record UserResponse(
        Long id,
        String email,
        String firstName,
        String lastName,
        Gender gender,
        LocalDate birthday
) {}
