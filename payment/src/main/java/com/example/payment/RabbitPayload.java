package com.example.payment;

import lombok.Data;
import java.io.Serializable;
import java.util.UUID;

@Data
public class RabbitPayload implements Serializable {
    private final String messageId;
    private final String message;

    public RabbitPayload(String message) {
        messageId = UUID.randomUUID().toString();
        this.message = message;
    }
}
