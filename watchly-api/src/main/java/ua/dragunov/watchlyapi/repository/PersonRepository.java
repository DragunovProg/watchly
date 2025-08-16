package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dragunov.watchlyapi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
