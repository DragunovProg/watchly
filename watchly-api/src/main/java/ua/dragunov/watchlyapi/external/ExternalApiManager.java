package ua.dragunov.watchlyapi.external;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.dragunov.watchlyapi.external.model.ExternalMediaDetails;
import ua.dragunov.watchlyapi.external.model.ExternalMediaItemSearchResult;
import ua.dragunov.watchlyapi.model.MediaType;

import java.util.List;
import java.util.Optional;

@Service
public class ExternalApiManager {
    private final List<ExternalApiProvider> providers;


    public ExternalApiManager(List<ExternalApiProvider> providers) {
        this.providers = providers;
    }

    public Page<ExternalMediaItemSearchResult> search(String query, List<Long> genres, int page) {
        if (providers.isEmpty()) {
            return Page.empty();
        }

        for (ExternalApiProvider provider : providers) {
            Page<ExternalMediaItemSearchResult> results = provider.search(query, genres, page);

            if (results.getTotalElements() > 0) {
                return results;
            }
        }

        return Page.empty();
    }

    public Optional<ExternalMediaDetails> findMediaDetails(long mediaId) {
        for (ExternalApiProvider provider : providers) {
            Optional<ExternalMediaDetails> mediaItemDetailsById = provider.findMediaItemDetailsById(mediaId);

            if (mediaItemDetailsById.isPresent()) {
                return mediaItemDetailsById;
            }
        }

        return Optional.empty();
    }
}
