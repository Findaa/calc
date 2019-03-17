package com.upcprovision.calc.repos;

import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

@Service
public interface MailService {
    void sendSimpleMessage (String to, String subject, String text) throws MailException, InterruptedException ;
}
