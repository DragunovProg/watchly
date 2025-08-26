package ua.dragunov.watchlyapi.external.tmdb.model;

import ua.dragunov.watchlyapi.model.CompanyType;

public record TmdbCompany(
        long externalId,
        String name,
        String country,
        CompanyType type
) {}
