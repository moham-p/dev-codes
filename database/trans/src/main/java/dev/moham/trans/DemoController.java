package dev.moham.trans;

import dev.moham.trans.DemoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	private final DemoService demoService;

	public DemoController(DemoService demoService) {
		this.demoService = demoService;
	}

	@PostMapping("/transfer")
	public String transferBalance(@RequestParam Long fromId, @RequestParam Long toId, @RequestParam int amount) {
		try {
			demoService.transferBalance(fromId, toId, amount);
			return "Transfer successful";
		} catch (Exception e) {
			return "Transfer failed: " + e.getMessage();
		}
	}
}
