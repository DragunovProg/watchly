package ua.dragunov.watchlyapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WatchlistItemId implements Serializable {
    @Column(name = "media_item_id")
    private long mediaItemId;

    @Column(name = "user_id")
    private long userId;

    public WatchlistItemId() {}

    public WatchlistItemId(long mediaItemId, long userId) {
        this.mediaItemId = mediaItemId;
        this.userId = userId;
    }

    public long getMediaItemId() {
        return mediaItemId;
    }

    public void setMediaItemId(long mediaItemId) {
        this.mediaItemId = mediaItemId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchlistItemId that = (WatchlistItemId) o;
        return mediaItemId == that.mediaItemId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaItemId, userId);
    }
}
