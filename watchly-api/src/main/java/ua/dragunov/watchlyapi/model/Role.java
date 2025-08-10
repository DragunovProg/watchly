package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "roles_seq", sequenceName = "roles_sequence", allocationSize = 1)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
