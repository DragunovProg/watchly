package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companies_seq")
    @SequenceGenerator(name = "companies_seq", sequenceName = "companies_sequence", allocationSize = 1)
    private Long id;

    private String name;

    private LocalDate foundedDate;

    private String country;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private CompanyType roleType;

    @OneToMany(mappedBy = "company")
    private Set<MediaItem> mediaItems = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) &&
                Objects.equals(foundedDate, company.foundedDate) &&
                Objects.equals(country, company.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, foundedDate, country);
    }
}
