package ua.dragunov.watchlyapi.external.tmdb.model;

import ua.dragunov.watchlyapi.model.Gender;
import ua.dragunov.watchlyapi.model.PersonRoleType;

public record TmdbPerson(
        long externalId,
        String fullName,
        String photoUrl,
        PersonRoleType roleType,
        Gender gender
) {}
