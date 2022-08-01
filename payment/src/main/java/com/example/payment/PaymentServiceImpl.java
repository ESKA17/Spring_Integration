package com.example.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final RabbitTemplate rabbitTemplate;
    @Override
    public void createPaymentRequest(PaymentRequest paymentRequest) {

        rabbitTemplate.convertAndSend(CORE_EXCHANGE, PAYMENT_ROUTING_KEY, message);
    }
}
