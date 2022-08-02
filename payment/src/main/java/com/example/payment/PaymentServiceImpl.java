package com.example.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.example.payment.Constants.CORE_EXCHANGE;
import static com.example.payment.Constants.PAYMENT_ROUTING_KEY;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final RabbitTemplate rabbitTemplate;
    @Override
    public void createPaymentRequest(PaymentRequest paymentRequest) {

        rabbitTemplate.convertAndSend(CORE_EXCHANGE, PAYMENT_ROUTING_KEY, paymentRequest);
    }
}
