package ua.dragunov.watchlyapi.external.model;

import java.util.List;
import java.util.Set;

public record ExternalMediaDetails(
    long externalId,
    String title,
    String description,
    String poster,
    int releaseYear,
    Set<ExternalGenre> genres,
    ExternalProductionCompany productionCompany,
    List<ExternalPerson> persons

) {}
