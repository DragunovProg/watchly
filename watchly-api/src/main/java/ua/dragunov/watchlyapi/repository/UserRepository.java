package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.dragunov.watchlyapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
