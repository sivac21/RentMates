package com.stackroute.emailservice.service;

import javax.mail.MessagingException;

public interface EmailService {
    void sendMail(String reciepent, String subject, String message) throws MessagingException;
}
