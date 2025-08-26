package ua.dragunov.watchlyapi.external.tmdb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TmdbCompanyResponse(
        long id,
        String name,
        @JsonProperty("origin_country")
        String country
) {}
