package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dragunov.watchlyapi.model.WatchlistItem;

@Repository
public interface WatchlistItemRepository extends JpaRepository<WatchlistItem, Long> {
}
