package dev.moham.trans;

import dev.moham.trans.DemoEntity;
import dev.moham.trans.DemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {
    private final DemoRepository demoRepository;

    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @Transactional
    public void transferBalance(Long fromId, Long toId, int amount) {
        DemoEntity from = demoRepository.findById(fromId).orElseThrow();
        DemoEntity to = demoRepository.findById(toId).orElseThrow();

        if (from.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        demoRepository.save(from);
        demoRepository.save(to);
    }
}
