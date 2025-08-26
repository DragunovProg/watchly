package ua.dragunov.watchlyapi.external.tmdb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CastResponse(
        long id,
        int gender,
        @JsonProperty("known_for_department")
        String knownForDepartment,
        @JsonProperty("name")
        String fullName,
        @JsonProperty("profile_path")
        String profilePath
) {}
