package dev.moham.trans;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DemoController {
    private final DemoService demoService;

    @PostMapping("/transfer")
    public String transferBalance(@RequestParam Long fromId, @RequestParam Long toId, @RequestParam int amount, @RequestParam boolean throwException) {
        demoService.transferBalance(fromId, toId, amount, throwException);
        return "Transfer successful";
    }

    @GetMapping("/accounts")
    public List<DemoEntity> getAllAccounts() {
        return demoService.getAllAccounts();
    }
}
