package ua.dragunov.watchlyapi.external.tmdb.model;

import java.util.List;
import java.util.Set;

public record TmdbMovie(
   long externalId,
   String title,
   String description,
   String poster,
   int releaseYear,
   Set<String> genres,
   List<TmdbPerson> persons,
   TmdbCompany company
) {}
