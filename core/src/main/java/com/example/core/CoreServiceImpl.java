package com.example.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoreServiceImpl implements CoreService {
    private final OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void markPayed(Order order) {
        Order orderInRepo = orderRepository.findByEmail(order.getEmail()).orElse(null);
        if (orderInRepo != null ){
            orderInRepo.setPayed(true);
            orderRepository.save(orderInRepo);
        }
    }
}
