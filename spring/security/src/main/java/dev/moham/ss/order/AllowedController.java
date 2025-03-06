package dev.moham.ss.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allowed")
public class AllowedController {

    @GetMapping
    public String getOrders() {
        return "Orders returned";
    }
}
