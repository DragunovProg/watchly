package ua.dragunov.watchlyapi.external.model;

import ua.dragunov.watchlyapi.model.Gender;
import ua.dragunov.watchlyapi.model.PersonRoleType;

import java.time.LocalDate;

public record ExternalPerson(
        long externalId,
        String fullName,
        String profilePath,
        String role,
        Gender gender,
        String biography,
        LocalDate birthDate
) {}
