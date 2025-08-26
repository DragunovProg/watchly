package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genres_seq")
    @SequenceGenerator(name = "genres_seq", sequenceName = "genres_sequence", allocationSize = 1)
    private long id;
    private String name;
    @Column(name = "external_id")
    private long externalId;
    @ManyToMany(mappedBy = "genres")
    private Set<MediaItem> mediaItems;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<MediaItem> getMediaItems() {
        return mediaItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return name.equals(genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
