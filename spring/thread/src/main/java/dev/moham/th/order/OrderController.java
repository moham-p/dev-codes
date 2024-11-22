package dev.moham.th.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderDTO request) {
        OrderResponse response = orderService.saveOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    // Other methods
}