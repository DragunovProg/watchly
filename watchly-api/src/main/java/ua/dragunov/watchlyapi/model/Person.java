package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persons_seq")
    @SequenceGenerator(name = "persons_seq", sequenceName = "persons_sequence", allocationSize = 1)
    private Long id;

    private String fullName;

    @Column(columnDefinition = "TEXT")
    private String biography;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    // Связь через MediaPersonRole
    @OneToMany(mappedBy = "person")
    private Set<MediaPersonRole> mediaRoles = new HashSet<>();
}
