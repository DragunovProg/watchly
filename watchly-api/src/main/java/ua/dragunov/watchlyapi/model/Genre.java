package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "genres_seq", sequenceName = "genres_sequence", allocationSize = 10)
    private long id;
    private String name;
    @ManyToMany(mappedBy = "genres")
    private List<MediaItem> mediaItems;

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
