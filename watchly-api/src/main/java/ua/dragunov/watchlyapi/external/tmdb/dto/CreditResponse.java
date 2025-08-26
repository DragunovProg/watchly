package ua.dragunov.watchlyapi.external.tmdb.dto;

import java.util.List;

public record CreditResponse(
        long id,
        List<CastResponse> cast,
        List<CrewResponse> crew
) {
}
