package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
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
}
