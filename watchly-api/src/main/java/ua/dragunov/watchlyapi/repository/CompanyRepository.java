package ua.dragunov.watchlyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.dragunov.watchlyapi.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
