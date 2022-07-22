package com.example.mailing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailingServiceImpl implements MailingService {
    private final JavaMailSender mailSender;

    @Override
    @Transactional
    @Async
    public void sendMail(String fromEmail, String toEmail)
            throws MessagingException, UnsupportedEncodingException {
        log.info("sending email started ...");
        String fromAddress = "tspring888@gmail.com";
        String senderName = "Mentorship Alumni NIS.";
        String subject = "Please verify your registration";
        String content = "Dear Sir/Madam,<br>"
                + "Please click the link below to verify your registration:<br>"
                + "Thank you,<br>"
                + "Order/Payment Integration.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toEmail);
        helper.setSubject(subject);

        helper.setText(content, true);
        mailSender.send(message);
        log.info("email is sent");
    }
}
