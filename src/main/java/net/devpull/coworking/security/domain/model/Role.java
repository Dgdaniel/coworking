package net.devpull.coworking.security.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import net.devpull.coworking.common.infrastructure.BaseEntity;

import java.util.List;

@Entity
@Table(name = "ROLES")
@Getter
@Setter
public class Role extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<UserAccount> userAccounts;
}
