package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.util.List;

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
}
