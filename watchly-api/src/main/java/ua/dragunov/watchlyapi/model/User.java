package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity()
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_seq_id", sequenceName = "user_sequence_id" , allocationSize = 1)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(name = "user_roles"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<WatchlistItem> watchlistItems;
}
