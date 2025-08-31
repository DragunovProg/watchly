package ua.dragunov.watchlyapi.external.tmdb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record MovieSearchResult(
        @JsonProperty("id")
        long id,
        String title,
        @JsonProperty("overview")
        String description,
        @JsonProperty("poster_path")
        String poster,
        @JsonProperty("release_date")
        LocalDate releaseDate,
        @JsonProperty("genres_ids")
        List<Long> genresIds
) {}
