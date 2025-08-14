package ua.dragunov.watchlyapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity()
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_seq_id", sequenceName = "user_sequence_id" , allocationSize = 1)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private LocalDate birthday;

    @ManyToMany
    @JoinTable(name = "user_roles"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Set<WatchlistItem> watchlistItems;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public Set<WatchlistItem> getWatchlistItems() {
        return watchlistItems;
    }

    public void addWatchlistItem(WatchlistItem watchlistItem) {
        watchlistItems.add(watchlistItem);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof User)) return false;

        User user = (User) obj;

        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
