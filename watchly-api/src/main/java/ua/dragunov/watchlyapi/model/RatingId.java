package ua.dragunov.watchlyapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RatingId implements Serializable {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "media_item_id")
    private Long mediaItemId;

    public RatingId() {}

    public RatingId(Long userId, Long mediaItemId) {
        this.userId = userId;
        this.mediaItemId = mediaItemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMediaItemId() {
        return mediaItemId;
    }

    public void setMediaItemId(Long mediaItemId) {
        this.mediaItemId = mediaItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RatingId)) return false;
        RatingId that = (RatingId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(mediaItemId, that.mediaItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, mediaItemId);
    }
}

