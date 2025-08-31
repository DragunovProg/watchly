package ua.dragunov.watchlyapi.external.model;

import java.time.LocalDate;

public record ExternalMediaItemSearchResult(
        long externalId,
        String title,
        String poster,
        LocalDate releaseDate
) {}
