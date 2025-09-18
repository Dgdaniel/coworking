package net.devpull.coworking.security.infrastructure.security;

import lombok.RequiredArgsConstructor;
import net.devpull.coworking.security.domain.model.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@RequiredArgsConstructor
public class UserAccountDetails implements UserDetails {
    private final UserAccount userAccount;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userAccount.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList();
    }

    @Override
    public String getPassword() {
        return userAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return userAccount.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !userAccount.isExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !userAccount.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !userAccount.isCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return userAccount.isEnabled();
    }
}
