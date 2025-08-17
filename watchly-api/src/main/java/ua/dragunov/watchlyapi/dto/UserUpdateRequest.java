package ua.dragunov.watchlyapi.dto;

import ua.dragunov.watchlyapi.model.Gender;

import java.time.LocalDate;

public record UserUpdateRequest(
        String firsName,
        String lastName,
        Gender gender,
        LocalDate birthday
) {}
