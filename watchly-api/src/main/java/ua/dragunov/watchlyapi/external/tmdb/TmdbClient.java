package ua.dragunov.watchlyapi.external.tmdb;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.dragunov.watchlyapi.external.tmdb.dto.CreditResponse;
import ua.dragunov.watchlyapi.external.tmdb.dto.MovieDetailsResponse;
import ua.dragunov.watchlyapi.external.tmdb.dto.MovieSearchResponse;
import ua.dragunov.watchlyapi.external.tmdb.dto.MovieSearchResult;
import ua.dragunov.watchlyapi.model.MediaItem;

import java.util.List;

@Service
public class TmdbClient {
    @Value("${tmdb.api.key}")
    private String apiKey;
    @Value(("${tmdb.base.url}"))
    private String baseUrl;
    @Value(("${tmdb.base.image.url}"))
    private String imageUrl;
    private RestTemplate restTemplate;

    public TmdbClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public MediaItem findMediaByParameters(String query, int releaseYear) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);


        ResponseEntity<MovieSearchResponse> response = restTemplate.exchange(
                String.format("%s/search/movie?query=%s&year=%s", baseUrl, query, releaseYear),
                HttpMethod.GET,
                new HttpEntity<Void>(headers),
                MovieSearchResponse.class
        );

        if (response.getStatusCode().isError()) {
            throw  new RuntimeException("tmdb search error with code " + response.getStatusCode());
        }

        MovieSearchResponse movieSearchResults = response.getBody();

        List<MovieDetailsResponse> details = movieSearchResults.results().stream()
                .map(movieSearchResult -> {
                    return restTemplate.exchange(
                            String.format("%s/movie/%d", baseUrl, movieSearchResult.id()),
                            HttpMethod.GET,
                            new HttpEntity<Void>(headers),
                            MovieDetailsResponse.class
                    ).getBody();
                })
                .toList();

        List<CreditResponse> credits = movieSearchResults.results().stream()
                .map(movieSearchResult -> {
                    return restTemplate.exchange(
                            String.format("%s/movie/%d/credits", baseUrl, movieSearchResult.id()),
                            HttpMethod.GET,
                            new HttpEntity<Void>(headers),
                            CreditResponse.class
                    ).getBody();
                })
                .toList();

        return null;
    }
}
