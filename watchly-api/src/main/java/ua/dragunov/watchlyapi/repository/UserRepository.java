package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dragunov.watchlyapi.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);

    public boolean existsByEmail(String email);

    public void deleteByEmail(String email);
}
