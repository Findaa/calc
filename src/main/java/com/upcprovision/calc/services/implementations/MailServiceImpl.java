package com.upcprovision.calc.services.implementations;

import com.upcprovision.calc.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    public MailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    private JavaMailSender emailSender;

    @Override
    @Async
    public void sendSimpleMessage(String to, String subject, String text) throws MailException, InterruptedException {
        System.out.println("Mail sent");
        Thread.sleep(5000);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
