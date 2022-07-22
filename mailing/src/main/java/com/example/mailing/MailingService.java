package com.example.mailing;

import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface MailingService {
    @Transactional
    @Async
    void sendMail(String email, String siteURL)
            throws MessagingException, UnsupportedEncodingException;
}
