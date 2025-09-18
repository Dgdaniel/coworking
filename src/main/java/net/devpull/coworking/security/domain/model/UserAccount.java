package net.devpull.coworking.security.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import net.devpull.coworking.common.infrastructure.BaseEntity;
import net.devpull.coworking.employee.domain.model.Employee;

import java.util.List;

@Entity
@Table(name = "USER_ACCOUNTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserAccount extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "is_enabled")
    private boolean enabled;

    @Column(name = "is_account_locked")
    private boolean locked;

    @Column(name = "is_expired")
    private boolean expired;

    @Column(name = "is_email_verified")
    private boolean emailVerified;

    @Column(name = "is_phone_verified")
    private boolean phoneVerified;

    @Column(name = "is_credentials_expired")
    private boolean credentialsExpired;

    @Column(nullable = false)
    private boolean active;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @OneToOne(mappedBy = "userAccount", fetch = FetchType.LAZY)
    private Employee employee;

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }

    public void lock() {
        this.locked = true;
    }

    public void unlock() {
        this.locked = false;
    }

    public void verifyEmail() {
        this.emailVerified = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }
}
