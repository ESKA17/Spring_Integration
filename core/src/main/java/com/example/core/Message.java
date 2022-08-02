package com.example.core;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Message {
    private String messageId;
    private LocalDateTime localDateTime;
    private String message;


    public Message(String message) {
        messageId = UUID.randomUUID().toString();
        localDateTime = LocalDateTime.now();
        this.message = message;
    }
}
