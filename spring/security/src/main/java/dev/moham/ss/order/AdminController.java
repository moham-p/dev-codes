package dev.moham.ss.order;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/orders")
public class AdminController {

    @GetMapping
    public String getOrders() {
        return "Admin orders returned";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_ORDER')")
    public String createOrder() {
        return "Order created";
    }
}
