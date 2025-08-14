package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.dragunov.watchlyapi.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
