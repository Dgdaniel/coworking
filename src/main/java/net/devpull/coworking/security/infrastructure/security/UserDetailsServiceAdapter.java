package net.devpull.coworking.security.infrastructure.security;

import lombok.RequiredArgsConstructor;
import net.devpull.coworking.security.domain.model.UserAccount;
import net.devpull.coworking.security.domain.port.UserAccountPort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceAdapter implements UserDetailsService {
    private final UserAccountPort userAccountPort;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserAccount user = userAccountPort.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(" User not found with email: " + email));
        return new UserAccountDetails(user);
    }
}
