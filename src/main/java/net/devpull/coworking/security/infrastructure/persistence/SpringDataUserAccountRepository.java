package net.devpull.coworking.security.infrastructure.persistence;

import net.devpull.coworking.security.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SpringDataUserAccountRepository extends JpaRepository<UserAccount, String> {
    Optional<UserAccount> findByEmail(String email);
    List<UserAccount> findByActiveTrue();
    List<UserAccount> findByActiveFalse();
    boolean existsByEmail(String email);
}
