package net.devpull.coworking.security.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import net.devpull.coworking.security.domain.model.UserAccount;
import net.devpull.coworking.security.domain.port.UserAccountPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@RequiredArgsConstructor
public class UserAccountJpaAdapter implements UserAccountPort {
    private final SpringDataUserAccountRepository repository;
    @Override
    public UserAccount save(UserAccount userAccount) {
        return repository.save(userAccount);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<UserAccount> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public List<UserAccount> findAllActiveUsers() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<UserAccount> findAllInActiveUsers() {
        return repository.findByActiveFalse();
    }


    @Override
    public void disableAccount(String userId) {
        repository.findById(userId).ifPresent(
                u -> {
                    u.disable();
                    repository.save(u);
                }
        );
    }

    @Override
    public void enableAccount(String userId) {
        repository.findById(userId).ifPresent(u -> {
            u.enable();
            repository.save(u);
        });
    }

    @Override
    public void lockAccount(String userId) {
        repository.findById(userId).ifPresent(u-> {
            u.lock();
            repository.save(u);
        });
    }

    @Override
    public void unlockAccount(String userId) {
        repository.findById(userId).ifPresent(u-> {
            u.unlock();
            repository.save(u);
        });

    }
}
