package com.stackroute.emailservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.security.MessageDigest;

@Service
public class EmailServiceImpl implements EmailService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String to, String subject, String message) throws MessagingException {

        String messageBody = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title> Page Title </title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p> Hi </p> \n" +
                "</body> \n" +
                "</html>";

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setTo(to);
        helper.setSubject(subject);
        mimeMessage.setContent(messageBody,"text/html");
        javaMailSender.send(mimeMessage);

//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setTo(to);
//        simpleMailMessage.setSubject(subject);
//        simpleMailMessage.setText(message);

        logger.info(subject);
        logger.info(to);
        logger.info(message);

//        javaMailSender.send(simpleMailMessage);
    }
}
