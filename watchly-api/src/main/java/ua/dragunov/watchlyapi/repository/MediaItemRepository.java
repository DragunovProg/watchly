package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.dragunov.watchlyapi.model.MediaItem;

public interface MediaItemRepository extends JpaRepository<MediaItem, Long> {
}
