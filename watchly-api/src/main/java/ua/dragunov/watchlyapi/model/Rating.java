package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "rating")
public class Rating {
    @EmbeddedId
    private RatingId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("mediaItemId")
    @JoinColumn(name = "media_item_id")
    private MediaItem mediaItem;

    private int score;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MediaItem getMediaItem() {
        return mediaItem;
    }

    public void setMediaItem(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Rating)) return false;

        Rating rating = (Rating) obj;

        return Objects.equals(user, rating.user)
               && Objects.equals(mediaItem, rating.mediaItem);


    }

    @Override
    public int hashCode() {
        return Objects.hash(user, mediaItem);
    }
}
