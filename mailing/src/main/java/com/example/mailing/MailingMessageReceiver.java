package com.example.mailing;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.example.mailing.Constants.MAIL_QUEUE;

@Component
public class MailingMessageReceiver {
    @RabbitListener(queues = MAIL_QUEUE)
    public void ordersListener(Message message) {
        System.out.println(message);
    }
}
