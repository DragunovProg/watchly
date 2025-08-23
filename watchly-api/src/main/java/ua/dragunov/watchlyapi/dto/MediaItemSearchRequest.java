package ua.dragunov.watchlyapi.dto;

import ua.dragunov.watchlyapi.model.MediaType;

import java.util.List;

public record MediaItemSearchRequest(
        String searchQuery,
        List<String> genres,
        MediaType mediaType,
        int releaseYear,
        int page,
        int size
) {}
