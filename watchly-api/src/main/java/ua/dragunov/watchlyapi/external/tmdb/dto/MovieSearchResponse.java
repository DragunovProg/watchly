package ua.dragunov.watchlyapi.external.tmdb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MovieSearchResponse(
        List<MovieSearchResult> results,
        int page,
        @JsonProperty("total_pages")
        int totalPages
) {}
