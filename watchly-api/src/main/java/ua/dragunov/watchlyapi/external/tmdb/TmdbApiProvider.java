package ua.dragunov.watchlyapi.external.tmdb;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import ua.dragunov.watchlyapi.external.ExternalApiProvider;
import ua.dragunov.watchlyapi.external.model.ExternalMediaDetails;
import ua.dragunov.watchlyapi.external.model.ExternalMediaItemSearchResult;
import ua.dragunov.watchlyapi.external.tmdb.dto.CreditResponse;
import ua.dragunov.watchlyapi.external.tmdb.dto.MovieDetailsResponse;
import ua.dragunov.watchlyapi.external.tmdb.dto.MovieSearchResponse;
import ua.dragunov.watchlyapi.external.tmdb.mapper.TmdbMediaItemMapper;
import ua.dragunov.watchlyapi.model.MediaType;

import java.util.List;
import java.util.Optional;

@Component
public class TmdbApiProvider implements ExternalApiProvider {
    private final TmdbClient tmdbClient;
    private final TmdbMediaItemMapper mediaItemMapper;

    public TmdbApiProvider(TmdbClient tmdbClient, TmdbMediaItemMapper mediaItemMapper) {
        this.tmdbClient = tmdbClient;
        this.mediaItemMapper = mediaItemMapper;
    }

    @Override
    public Page<ExternalMediaItemSearchResult> search(String query, List<Long> genres, int page) {
        MovieSearchResponse result = tmdbClient.search(query, page, genres);

        Pageable pageable = PageRequest.of(page, 20);

        return new PageImpl<>(
                result.results().stream()
                        .map(mediaItemMapper::toExternalMediaSearchResult)
                        .toList()
                , pageable, result.totalResults());
    }

    @Override
    public Optional<ExternalMediaDetails> findMediaItemDetailsById(long externalId) {
        MovieDetailsResponse movieDetails = tmdbClient.findMovieDetails(externalId);
        CreditResponse creditsByMovie = tmdbClient.findCreditsByMovie(externalId);


        return Optional.empty();
    }
}
