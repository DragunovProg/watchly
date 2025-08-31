package ua.dragunov.watchlyapi.external.tmdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.dragunov.watchlyapi.external.tmdb.config.TmdbProperties;
import ua.dragunov.watchlyapi.external.tmdb.dto.CreditResponse;
import ua.dragunov.watchlyapi.external.tmdb.dto.MovieDetailsResponse;
import ua.dragunov.watchlyapi.external.tmdb.dto.MovieSearchResponse;

import java.util.*;

@Service
public class TmdbClient {
    private static final Logger logger = LoggerFactory.getLogger(TmdbClient.class);

    private final TmdbProperties props;
    private final HttpHeaders headers;
    private final RestTemplate restTemplate;

    public TmdbClient(RestTemplate restTemplate, TmdbProperties props) {
        this.restTemplate = restTemplate;
        this.props = props;

        headers = new HttpHeaders();
        headers.setBearerAuth(props.getApiKey());
    }


    public MovieSearchResponse search(String query, Integer page, List<Long> genresId) {
        String searchEndpoint = String.format("%s/search/movie?query=%s&page=%d", props.getBaseUrl(), query, page);
        logger.debug("request to {} endpoint ", searchEndpoint);

        MovieSearchResponse result = Optional.ofNullable(restTemplate.exchange(
                searchEndpoint,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                MovieSearchResponse.class
        ).getBody()).orElseThrow( () -> new RuntimeException("Search Failed"));

        if (result.results().isEmpty()) {
            return result;
        }

        return new MovieSearchResponse(
                result.results().stream()
                        .filter(movieSearchResult -> {
                            if (genresId == null)
                                return true;

                            return new HashSet<>(movieSearchResult
                                    .genresIds()).containsAll(genresId);
                        })
                        .toList()
                ,
                result.page(),
                result.totalPages(),
                result.totalResults()
        );
    }

    public MovieDetailsResponse findMovieDetails(long movieId) {
        return restTemplate.exchange(
                String.format("%s/movie/%d", props.getBaseUrl(), movieId),
                HttpMethod.GET,
                new HttpEntity<>(headers),
                MovieDetailsResponse.class
        ).getBody();
    }

    public CreditResponse findCreditsByMovie(long movieId) {
        return restTemplate.exchange(
                String.format("%s/movie/%d/credits", props.getBaseUrl(), movieId),
                HttpMethod.GET,
                new HttpEntity<>(headers),
                CreditResponse.class
        ).getBody();
    }


}
