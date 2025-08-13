package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.util.Objects;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return name.equals(role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
