package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "media_person_roles")
public class MediaPersonRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "media_person_roles_seq")
    @SequenceGenerator(name = "media_person_roles_seq", sequenceName = "media_person_roles_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "media_item_id", nullable = false)
    private MediaItem mediaItem;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Enumerated(EnumType.STRING)
    private PersonRoleType personRoleType;

    @Enumerated(EnumType.STRING)
    private MediaType mediaType;
}