package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.dragunov.watchlyapi.model.WatchlistItem;

public interface WatchlistItemRepository extends JpaRepository<WatchlistItem, Long> {
}
