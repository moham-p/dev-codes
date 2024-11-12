package dev.moham.ss.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class Controller {

    @GetMapping
    public String getOrders() {
        return "Orders returned";
    }
}
