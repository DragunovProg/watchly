package ua.dragunov.watchlyapi.dto;

import ua.dragunov.watchlyapi.model.MediaType;

import java.util.List;
import java.util.Set;

public record MediaItemResponse(
        Long id,
        String title,
        String description,
        MediaType mediaType,
        String posterUrl,
        int releaseYear,
        int rating,
        int votedAmount,
        Set<String> genres,
        List<PersonPreviewResponse> persons,
        CompanyPreviewResponse company
) {}
