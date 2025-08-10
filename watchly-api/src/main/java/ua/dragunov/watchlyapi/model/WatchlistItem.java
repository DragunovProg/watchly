package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "watchlist_item")
public class WatchlistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "watchlist_item_seq", sequenceName = "watchlist_item_sequenct", allocationSize = 1)
    private long id;
    @ManyToOne
    @JoinColumn(name = "media_item_id")
    private MediaItem mediaItem;
    @Enumerated(EnumType.STRING)
    private WatchStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
