package dev.moham.trans;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DemoService {

    private final DemoRepository demoRepository;

    @Transactional
    public void transferBalance(Long fromId, Long toId, int amount, boolean throwException) {
        DemoEntity from = demoRepository.findById(fromId).orElseThrow();
        DemoEntity to = demoRepository.findById(toId).orElseThrow();

        if (from.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        demoRepository.save(from);
        demoRepository.save(to);

        if (throwException)
            throw new RuntimeException("This is a test exception");
    }

    public List<DemoEntity> getAllAccounts() {
        return demoRepository.findAll();
    }
}
