package dev.moham.th.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponse saveOrder(OrderDTO request) {
        Order order = new Order();
        order.setName(request.getName());
        order.setDescription(request.getDescription());
        Order savedOrder = orderRepository.save(order);

        OrderResponse response = new OrderResponse();
        response.setId(savedOrder.getId());
        response.setName(savedOrder.getName());
        response.setDescription(savedOrder.getDescription());
        return response;
    }
    // Other business methods
}