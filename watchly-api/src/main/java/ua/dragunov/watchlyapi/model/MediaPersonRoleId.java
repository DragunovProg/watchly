package ua.dragunov.watchlyapi.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class MediaPersonRoleId implements Serializable {
    private long mediaItemId;
    private UUID personId;

    public MediaPersonRoleId() {}

    public long getMediaItemId() {
        return mediaItemId;
    }

    public void setMediaItemId(long mediaItemId) {
        this.mediaItemId = mediaItemId;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MediaPersonRoleId that = (MediaPersonRoleId) o;
        return mediaItemId == that.mediaItemId && personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaItemId, personId);
    }
}
