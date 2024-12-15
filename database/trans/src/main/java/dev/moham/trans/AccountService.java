package dev.moham.trans;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public void transferBalance(Long fromId, Long toId, int amount, boolean throwException) {
        AccountEntity from = accountRepository.findById(fromId).orElseThrow();
        AccountEntity to = accountRepository.findById(toId).orElseThrow();

        if (from.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountRepository.save(from);
        accountRepository.save(to);

        if (throwException)
            throw new RuntimeException("This is a test exception");
    }

    public List<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }
}
