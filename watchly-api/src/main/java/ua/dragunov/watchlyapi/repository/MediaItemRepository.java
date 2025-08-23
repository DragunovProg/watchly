package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ua.dragunov.watchlyapi.model.MediaItem;

@Repository
public interface MediaItemRepository extends JpaRepository<MediaItem, Long>, JpaSpecificationExecutor<MediaItem> {
}
