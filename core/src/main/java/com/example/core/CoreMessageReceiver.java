package com.example.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static com.example.core.Constants.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class CoreMessageReceiver {
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = ORDER_QUEUE)
    public void ordersListener(Message message) {
        Message notificationMessage = new Message("New Order Notification #" +
                message.getMessage().split("#")[1]);
        rabbitTemplate.convertAndSend(MAIL_EXCHANGE, MAIL_ROUTING_KEY, notificationMessage);
    }

    @RabbitListener(queues = PAYMENT_QUEUE)
    public void paymentsListener(Message message) {
        Message notificationMessage = new Message("New Payment Notification #" +
                message.getMessage().split("#")[1]);
        rabbitTemplate.convertAndSend(MAIL_EXCHANGE, MAIL_ROUTING_KEY, notificationMessage);
    }
}
