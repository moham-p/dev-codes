package dev.moham.th;

import dev.moham.th.order.Order;
import dev.moham.th.order.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(OrderRepository repository) {
        return args -> {
            repository.save(Order.builder().name("Order one").description("This is the first order").build());
            repository.save(Order.builder().name("Order two").description("This is the second order").build());
            repository.save(Order.builder().name("Order three").description("This is the third order").build());
        };
    }
}