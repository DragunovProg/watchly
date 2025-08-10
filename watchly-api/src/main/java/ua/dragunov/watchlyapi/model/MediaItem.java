package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "media_items")
public class MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "media_items_seq", sequenceName = "media_items_sequence", allocationSize = 1)
    private int id;
    private String title;
    private String description;
    private String poster;
    @Column(name = "created_at")
    private ZonedDateTime createdAt;
    @Column(name = "release_year")
    private int releaseYear;
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

}
