package ua.dragunov.watchlyapi.dto;

public record MediaItemPreviewResponse(
        Long id,
        String title,
        int releaseYear,
        String poster,
        double rating
) {}
