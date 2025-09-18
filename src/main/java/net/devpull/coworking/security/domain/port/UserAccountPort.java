package net.devpull.coworking.security.domain.port;


import net.devpull.coworking.security.domain.model.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountPort {
    UserAccount save(UserAccount userAccount);
    void deleteById(String id);
    Optional<UserAccount> findById(String id);
    Optional<UserAccount> findByEmail(String email);
    boolean existsByEmail(String email);

    List<UserAccount> findAllActiveUsers();
    List<UserAccount> findAllInActiveUsers();

    void disableAccount(String userId);
    void enableAccount(String userId);
    void lockAccount(String userId);
    void unlockAccount(String userId);
}
