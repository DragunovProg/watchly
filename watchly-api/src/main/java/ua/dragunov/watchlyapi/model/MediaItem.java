package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "media_items")
public class MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "media_items_seq", sequenceName = "media_items_sequence", allocationSize = 1)
    private int id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String poster;
    @Column(name = "created_at")
    private ZonedDateTime createdAt;
    @Column(name = "release_year")
    private int releaseYear;
    private int rating;

    @ManyToMany
    @JoinTable(
            name = "media_genres",
            joinColumns = @JoinColumn(name = "media_item_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    @OneToMany(mappedBy = "mediaItem", cascade = {CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<MediaPersonRole> persons  = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<MediaPersonRole> getPersons() {
        return persons;
    }

    public void setPersons(Set<MediaPersonRole> persons) {
        this.persons = persons;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MediaItem mediaItem = (MediaItem) o;
        return releaseYear == mediaItem.releaseYear &&
                Objects.equals(title, mediaItem.title) &&
                Objects.equals(company, mediaItem.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseYear, company);
    }
}
