package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "media_person_roles")
public class MediaPersonRole {
    @EmbeddedId
    private MediaPersonRoleId mediaPersonRoleId;

    @ManyToOne
    @MapsId("mediaItemId")
    @JoinColumn(name = "media_item_id", nullable = false)
    private MediaItem mediaItem;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Enumerated(EnumType.STRING)
    private PersonRoleType personRoleType;

    @Enumerated(EnumType.STRING)
    private MediaType mediaType;


    public MediaItem getMediaItem() {
        return mediaItem;
    }

    public Person getPerson() {
        return person;
    }

    public PersonRoleType getPersonRoleType() {
        return personRoleType;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setPersonRoleType(PersonRoleType personRoleType) {
        this.personRoleType = personRoleType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MediaPersonRole mediaPersonRole = (MediaPersonRole) o;
        return Objects.equals(mediaItem, mediaPersonRole.mediaItem)
                && Objects.equals(person, mediaPersonRole.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaItem, person);
    }
}