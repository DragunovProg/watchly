package ua.dragunov.watchlyapi.external.tmdb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CrewResponse(
        long id,
        int gender,
        String job,
        String fullName,
        @JsonProperty("profile_path")
        String profilePath
) {}
