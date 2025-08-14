package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.dragunov.watchlyapi.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
