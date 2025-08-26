package ua.dragunov.watchlyapi.external.tmdb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record MovieDetailsResponse(
        long id,
        String title,
        String overview,
        @JsonProperty("poster_path")
        String poster,
        @JsonProperty("release_date")
        LocalDate releaseDate,
        List<TmdbGenreResponse> genres,
        @JsonProperty("production_companies")
        List<TmdbCompanyResponse> productionCompanies
) {
}
