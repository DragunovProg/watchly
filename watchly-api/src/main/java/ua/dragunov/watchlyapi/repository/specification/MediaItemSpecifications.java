package ua.dragunov.watchlyapi.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import ua.dragunov.watchlyapi.model.MediaItem;
import ua.dragunov.watchlyapi.model.MediaType;

import java.util.List;

public class MediaItemSpecifications {

    public static Specification<MediaItem> titleContains(String title) {
        return (root, query, cb) ->
                title == null || title.isBlank() ? null :
                        cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<MediaItem> hasType(MediaType type) {
        return (root, query, cb) -> type == null ? null : cb.equal(root.get("type"), type);
    }

    public static Specification<MediaItem> releasedIn(Integer year) {
        return (root, query, cb) -> year == null ? null : cb.equal(root.get("releaseYear"), year);
    }

    public static Specification<MediaItem> hasGenres(List<String> genres) {
        return (root, query, cb) -> {
            if (genres == null || genres.isEmpty()) return null;

            return root.join("genres").get("name").in(genres);
        };
    }
}
