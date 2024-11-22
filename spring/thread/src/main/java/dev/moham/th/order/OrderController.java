package dev.moham.th.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {

        log.info("OrderController HashCode: {}", System.identityHashCode(this));

        var response = orderService.findAll()
                .stream()
                .map(order -> new OrderDTO(order.getName(), order.getDescription()))
                .toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}