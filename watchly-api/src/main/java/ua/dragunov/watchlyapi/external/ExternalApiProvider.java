package ua.dragunov.watchlyapi.external;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ua.dragunov.watchlyapi.external.model.ExternalMediaDetails;
import ua.dragunov.watchlyapi.external.model.ExternalMediaItemSearchResult;
import ua.dragunov.watchlyapi.model.MediaType;

import java.util.List;
import java.util.Optional;


public interface ExternalApiProvider {

    Page<ExternalMediaItemSearchResult> search(String search, List<Long> genresId, int page);

    Optional<ExternalMediaDetails> findMediaItemDetailsById(long externalId);


}
