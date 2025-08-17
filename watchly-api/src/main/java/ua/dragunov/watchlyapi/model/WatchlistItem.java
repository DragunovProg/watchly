package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "watchlist_item")
public class WatchlistItem {
    @EmbeddedId
    private WatchlistItemId id;

    @ManyToOne
    @MapsId("mediaItemId")
    @JoinColumn(name = "media_item_id")
    private MediaItem mediaItem;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private WatchStatus status;



    public WatchStatus getStatus() {
        return status;
    }

    public MediaItem getMediaItem() {
        return mediaItem;
    }

    public User getUser() {
        return user;
    }

    public void setStatus(WatchStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchlistItem watchlistItem = (WatchlistItem) o;
        return Objects.equals(mediaItem, watchlistItem.mediaItem)
                && Objects.equals(user, watchlistItem.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaItem, user);
    }
}
