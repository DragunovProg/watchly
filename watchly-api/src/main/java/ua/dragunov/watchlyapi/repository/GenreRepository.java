package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.dragunov.watchlyapi.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
