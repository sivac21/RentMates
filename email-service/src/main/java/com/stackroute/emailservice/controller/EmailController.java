package com.stackroute.emailservice.controller;

import com.stackroute.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/v1")
public class EmailController {

    private ResponseEntity responseEntity;
    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> sendMail(@PathVariable("email") String email) throws MessagingException {
        String message = "Hi,... If u recieve this, our email service is working just fine :D";

        emailService.sendMail(email,"Confirmation of working service", message);
        return responseEntity;
    }
}
