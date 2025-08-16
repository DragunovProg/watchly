package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dragunov.watchlyapi.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
