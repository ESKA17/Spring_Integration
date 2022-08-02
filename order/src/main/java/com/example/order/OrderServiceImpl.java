package com.example.order;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.example.order.Constants.CORE_EXCHANGE;
import static com.example.order.Constants.ORDER_ROUTING_KEY;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final RabbitTemplate rabbitTemplate;
    private static int counter = 0;
    @Override
    public void createOrder(OrderRequest orderRequest) {
        OrderModel order = OrderModel.builder()
                .amount(orderRequest.getAmount())
                .email(orderRequest.getEmail())
                .payed(false)
                .build();
        var dto = new Message("New Order #" + ++counter + ": " + order);
        rabbitTemplate.convertAndSend(CORE_EXCHANGE, ORDER_ROUTING_KEY, dto);
    }
}
