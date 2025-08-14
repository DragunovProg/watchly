package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.dragunov.watchlyapi.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
