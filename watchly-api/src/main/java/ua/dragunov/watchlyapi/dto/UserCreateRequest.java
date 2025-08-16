package ua.dragunov.watchlyapi.dto;

import ua.dragunov.watchlyapi.model.Gender;

import java.time.LocalDate;

public record UserCreateRequest(
        String email,
        String password,
        String firsName,
        String lastName,
        Gender gender,
        LocalDate birthday
) {}
