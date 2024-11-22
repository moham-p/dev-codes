package dev.moham.th.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> findAll() {
        log.info("OrderService HashCode: {}", System.identityHashCode(this));
        log.info("OrderRepository HashCode: {}", System.identityHashCode(orderRepository));

        return orderRepository.findAll();
    }
}