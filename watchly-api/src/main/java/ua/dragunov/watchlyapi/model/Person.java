package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @Column(updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();

    private String fullName;

    @Column(columnDefinition = "TEXT")
    private String biography;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "person")
    private Set<MediaPersonRole> mediaRoles = new HashSet<>();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public Set<MediaPersonRole> getMediaRoles() {
        return mediaRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
